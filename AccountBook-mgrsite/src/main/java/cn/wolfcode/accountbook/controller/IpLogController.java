package cn.wolfcode.accountbook.controller;


import cn.wolfcode.accountbook.base.annotation.NeedLogin;
import cn.wolfcode.accountbook.base.query.IpLogQuery;
import cn.wolfcode.accountbook.base.query.PageResult;
import cn.wolfcode.accountbook.base.service.IIpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

/**
 * 登录记录
 */
@Controller
public class IpLogController {
    @Autowired
    private IIpLogService ipLogService;

    @RequestMapping("ipLog")
    @NeedLogin
   public String list(@ModelAttribute("qo") IpLogQuery qo, Model mode){

        PageResult pageResult = ipLogService.selectForList(qo);
        mode.addAttribute("pageResult",pageResult);
        return "ipLog/list";
    }

}
