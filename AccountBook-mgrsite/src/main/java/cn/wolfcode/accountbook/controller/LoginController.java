package cn.wolfcode.accountbook.controller;


import cn.wolfcode.accountbook.base.annotation.NeedLogin;
import cn.wolfcode.accountbook.base.domain.IpLog;
import cn.wolfcode.accountbook.base.domain.LoginInfo;
import cn.wolfcode.accountbook.base.exception.CustomException;
import cn.wolfcode.accountbook.base.service.IIpLogService;
import cn.wolfcode.accountbook.base.service.ILoginInfoService;
import cn.wolfcode.accountbook.util.JsonResult;
import cn.wolfcode.accountbook.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录功能
 */

@Controller
public class LoginController {

    @Autowired
    private ILoginInfoService loginInfoService;

    @Autowired
    private IIpLogService ipLogService;

    /**
     * 后台登录
     */
    @RequestMapping("userLogin")
    @ResponseBody
    public JsonResult login(LoginInfo loginInfo) {
        System.out.println(MD5.encode(loginInfo.getPassword()+loginInfo.getUsername()));
        int state = IpLog.STATE_ERROR;
        JsonResult jsonResult = new JsonResult();
        try {
            loginInfo.setUserType(LoginInfo.USERTYPE_MGRSITE);
            loginInfoService.login(loginInfo);
            state = IpLog.STATE_SUCCESS;
        } catch (CustomException e) {
            jsonResult.setMessage(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setMessage("系统异常啦,请稍后再试");
        }
        //保存登录记录
        ipLogService.save(loginInfo.getUsername(), state, LoginInfo.USERTYPE_MGRSITE);

        return jsonResult;

    }


    /**
     * 主页面
     */
    @RequestMapping("main")
    @NeedLogin
    public String main(){
        return "main";
    }
}
