package cn.wolfcode.accountbook.base.service.impl;


import cn.wolfcode.accountbook.base.exception.CustomException;
import cn.wolfcode.accountbook.base.service.ISendVerifyCodeService;
import cn.wolfcode.accountbook.base.vo.VerifyCodeVO;
import cn.wolfcode.accountbook.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class SendVerifyCodeServiceImpl implements ISendVerifyCodeService {


    public void sendVerifyCode(String phone) {
        //判断手机号
        AssertUtil.instance().isMobile(phone,"无效的手机号");

        //判断发送频繁,上一次发送时间和当前时间的间隔判断
        VerifyCodeVO verifyCodeVO = UserContext.getVerifyCodeVO();
        Date time = new Date();
        if(verifyCodeVO != null && verifyCodeVO.getPhone().equals(phone)){
            Date sendTime = verifyCodeVO.getSendTime();
            AssertUtil.instance().isFalse(DateUtil.getSecondsBetween(time,sendTime) < Constants.VERIFYCODE_SEND_INTERVAL_SECOND,
                    "发送频繁,请稍后再试");
        }


        //创建一个验证码
        String code = UUID.randomUUID().toString().substring(0, 4);
        //执行发送
        System.out.println("验证码:"+code);
        //send(phone,code);


        //保存记录
        VerifyCodeVO vo = new VerifyCodeVO();
        vo.setCode(code);
        vo.setPhone(phone);
        vo.setSendTime(time);

        //保存到session中
        UserContext.setVerifyCodeVO(vo);

    }


    //执行短信发送
    private void send(String phone,String code){
       Map<String,String> map = new HashMap<>();
        map.put("Uid","https://way.jd.com/fegine/fesms");
        map.put("Key","528f9389229b54891476e7f0d9a25fa6");
        map.put("smsMob",phone);
        map.put("smsText","你的验证码是:"+code+"请在5分钟内使用");

        try {
            String request = HttpUtil.sendHttpRequest("http://utf8.api.smschinese.cn/", map);
            if(request.equals("-3")){
                throw new CustomException("短信验证失败[-3],请重新联系客服");
            }
        }catch (CustomException e){
            throw new CustomException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("系统异常");
        }

       /* RequestModel model = new RequestModel();
        model.setGwUrl("https://way.jd.com/fegine/fesms");
        model.setAppkey("528f9389229b54891476e7f0d9a25fa6");
        Map queryMap = new HashMap();
        queryMap.put("phone",phone); //访问参数
        queryMap.put("code","你的验证码是:"+code+"请在5分钟内使用"); //访问参数
        queryMap.put("skin","1"); //访问参数
        queryMap.put("sign","1"); //访问参数
        model.setQueryParams(queryMap);
        WxApiCall call = new WxApiCall();
        call.setModel(model);
        call.request();
*/

    }
}
