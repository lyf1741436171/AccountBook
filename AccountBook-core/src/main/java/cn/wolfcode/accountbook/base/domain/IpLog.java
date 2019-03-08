package cn.wolfcode.accountbook.base.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class IpLog extends BaseDomain {
    /**
     *登录成功
     */
    public static final int STATE_SUCCESS = 0;

    /**
     * 登录失败
     */
    public static final int STATE_ERROR = 1;

    //用户名
    private String username;

    //ip体地址
    private String ip;

    //登录时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date loginTime;

    //状态
    private int state = STATE_SUCCESS;


    private int userType = LoginInfo.USERTYPE_WEBSITE;


    public String getUserTypeDisplayName() {
        return userType == LoginInfo.USERTYPE_WEBSITE ? "前台用户" : "后台用户";
    }

    public String getStateDisplayName() {
        return state == STATE_SUCCESS ? "登录成功" : "登录失败";
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
