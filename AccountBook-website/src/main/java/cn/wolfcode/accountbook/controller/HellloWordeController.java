package cn.wolfcode.accountbook.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HellloWordeController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "你好世界";
    }

}
