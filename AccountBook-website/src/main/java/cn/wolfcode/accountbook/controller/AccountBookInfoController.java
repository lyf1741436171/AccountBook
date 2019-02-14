package cn.wolfcode.accountbook.controller;

import cn.wolfcode.accountbook.base.domain.AccountBookInfo;
import cn.wolfcode.accountbook.base.query.AccountBookQuery;
import cn.wolfcode.accountbook.base.query.PageResult;
import cn.wolfcode.accountbook.base.service.IAccountBookInfoService;
import cn.wolfcode.accountbook.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("accountBookInfo")
public class AccountBookInfoController {
    @Autowired
    private IAccountBookInfoService AccountBookInfoService;

    @RequestMapping("list")
    public String list(@ModelAttribute("qo") AccountBookQuery qo, Model mode) {
        PageResult pageResult = AccountBookInfoService.selectForList(qo);
        mode.addAttribute("pageResult", pageResult);
        return "accountbookinfo_list";
    }

    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public JSONResult saveOrUpdate (AccountBookInfo accountBookInfo) {
        JSONResult jsonResult = new JSONResult();
        try{
             AccountBookInfoService.saveOrUpdate(accountBookInfo);
        }catch (Exception e){
            e.printStackTrace();
              jsonResult.mark("执行失败");
        }
        return   jsonResult;

    }


}
