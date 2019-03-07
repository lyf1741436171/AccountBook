package cn.wolfcode.accountbook.controller;

import cn.wolfcode.accountbook.base.domain.AccountBookInfo;
import cn.wolfcode.accountbook.base.query.AccountBookQuery;
import cn.wolfcode.accountbook.base.query.PageResult;
import cn.wolfcode.accountbook.base.service.IAccountBookInfoService;
import cn.wolfcode.accountbook.util.JSONResult;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("accountBookInfo")
public class AccountBookInfoController {
    @Autowired
    private IAccountBookInfoService accountBookInfoService;

    @RequestMapping("list")
    public String list(@ModelAttribute("qo") AccountBookQuery qo, Model mode) {
        PageResult pageResult = accountBookInfoService.selectForList(qo);
        mode.addAttribute("pageResult", pageResult);
        return "accountbookinfo_list";
    }

    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public JSONResult saveOrUpdate(AccountBookInfo accountBookInfo) {
        JSONResult jsonResult = new JSONResult();
        try {
            accountBookInfoService.saveOrUpdate(accountBookInfo);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.mark("执行失败");
        }
        return jsonResult;

    }
    @RequestMapping("delete")
    @ResponseBody
    public JSONResult delete(Long id){
        JSONResult jsonResult = new JSONResult();
        try {
            accountBookInfoService.deleteUser(id);
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.mark("删除失败");
        }
        return jsonResult;
    }

    @RequestMapping("export")
    public ModelAndView export(HttpServletResponse response, HttpServletRequest request) throws Exception {
        //创建工作薄
        Workbook wb = new XSSFWorkbook();
        //创建第一页数
        Sheet sheet = wb.createSheet("工作薄");
        //创建一行
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("工人");
        row.createCell(1).setCellValue("工作类型");
        row.createCell(2).setCellValue("工号");
        row.createCell(3).setCellValue("工作时间");
        row.createCell(4).setCellValue("备注");
        row = sheet.createRow(1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        List<AccountBookInfo> accountBookInfos = accountBookInfoService.selectAll();
        for (int i = 0; i < accountBookInfos.size(); i++) {
            AccountBookInfo info = accountBookInfos.get(i);
            row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(info.getWorkName());
            row.createCell(1).setCellValue(info.getWorkType());
            row.createCell(2).setCellValue(info.getWorkNumber());
            String format1 = format.format(info.getDate());
            row.createCell(3).setCellValue(format1);
            row.createCell(4).setCellValue(accountBookInfos.get(i).getRemark());
        }
        response.setHeader("Content-Disposition", "attachment; fileName=" + UUID.randomUUID() + ".xlsx");
        wb.write(response.getOutputStream());
        return null;

    }

    @RequestMapping("import")
    public String importExcel(MultipartFile xlsx) throws Exception {
        String xlsxType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        String xlsType = "application/vnd.ms-excel";
        if(xlsx != null && xlsxType.equals(xlsx.getContentType()) || xlsType.equals(xlsx.getContentType())){
            Workbook wb = new XSSFWorkbook(xlsx.getInputStream());
            Sheet sheetAt = wb.getSheetAt(0);
            int lastRowNum = sheetAt.getLastRowNum();
            if(lastRowNum >= 1){
                for (int i = 0; i < lastRowNum; i++) {
                    Row row = sheetAt.getRow(i + 1);
                    String workName = row.getCell(0).getStringCellValue();
                    String workType = row.getCell(1).getStringCellValue();
                    String workNumber = row.getCell(2).getStringCellValue();
                    Date date = row.getCell(3).getDateCellValue();
                    String remark = row.getCell(4).getStringCellValue();
                    AccountBookInfo info = new AccountBookInfo();
                    info.setWorkName(workName);
                    info.setWorkType(workType);
                    info.setWorkNumber(workNumber);
                    info.setDate(date);
                    info.setRemark(remark);
                    info.setState(1);
                    info.setActive(1);
                    accountBookInfoService.saveOrUpdate(info);
                }
            }
        }
        return "redirect:/accountBookInfo/list";
    }

}
