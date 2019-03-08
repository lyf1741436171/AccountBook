package cn.wolfcode.accountbook.controller;


import cn.wolfcode.accountbook.base.exception.CustomException;
import cn.wolfcode.accountbook.base.service.ILoginInfoService;
import cn.wolfcode.accountbook.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 前台注册逻辑
 */
@Controller
public class RegisterController {

    @Autowired
    private ILoginInfoService loginInfoService ;

    /**
     * 前台注册Circular view path [userRegister]
     */
    @RequestMapping("userRegister")
    @ResponseBody
    public JsonResult userRegister(String username, String verifycode, String password, String confirmPwd){
        JsonResult jsonResult = new JsonResult();
        try{
            loginInfoService.register( username, verifycode, password, confirmPwd);
        }catch (CustomException e){
            jsonResult.setMessage(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setMessage("系统异常啦,请稍后再试");
        }
        return jsonResult;
    }

    /**
     * 判断手机号是否已注册
     * @param username
     * @return
     */
    @RequestMapping("exisUsername")
    @ResponseBody
    public boolean exisUsername(String username){
        return !loginInfoService.exisUsername(username);
    }


}
