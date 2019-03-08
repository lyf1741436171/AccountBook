package cn.wolfcode.accountbook.controller;


import cn.wolfcode.accountbook.base.exception.CustomException;
import cn.wolfcode.accountbook.base.service.ISendVerifyCodeService;
import cn.wolfcode.accountbook.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 验证码验证
 */
@Controller
public class SendVerifyCodeController {
    @Autowired
    private ISendVerifyCodeService sendVerifyCodeService;



    @RequestMapping("sendVerifyCode")
    @ResponseBody
    public JsonResult sendVerifyCode(String phone){
         JsonResult jsonResult = new JsonResult();
        try {
            sendVerifyCodeService.sendVerifyCode(phone);
         } catch (CustomException e) {
               jsonResult.setMessage(e.getMessage());
         } catch (Exception e) {
               e.printStackTrace();
               jsonResult.setMessage("系统繁忙,请稍后再试");
         }
          return jsonResult;
    }
}
