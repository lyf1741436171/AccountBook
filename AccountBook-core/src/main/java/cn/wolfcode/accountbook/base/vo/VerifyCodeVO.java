package cn.wolfcode.accountbook.base.vo;


import java.util.Date;

public class VerifyCodeVO {

    //验证码
    private String code;
    //发送时间
    private Date sendTime;
    //手机号码
    private  String phone;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
