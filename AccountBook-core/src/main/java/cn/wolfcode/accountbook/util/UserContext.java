package cn.wolfcode.accountbook.util;

import cn.wolfcode.accountbook.base.domain.LoginInfo;
import cn.wolfcode.accountbook.base.vo.VerifyCodeVO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserContext {

    private static final String VERIFYCODE_IN_SESSION = "verifycode_in_session";
    private static final String LOGININFO_IN_SESSION = "logininfo";

    /**
     * 获取session
     * @return
     */
    public static HttpSession getSession(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return request.getSession();
    }

    /**
     * 保存验证码发送记录到session
     * @param vo
     */
    public static void setVerifyCodeVO(VerifyCodeVO vo){
        getSession().setAttribute(VERIFYCODE_IN_SESSION,vo);
    }

    /**
     * 从session中获取验证码发送记录
     * @return
     */
    public static VerifyCodeVO getVerifyCodeVO(){
        return (VerifyCodeVO) getSession().getAttribute(VERIFYCODE_IN_SESSION);
    }

    /**
     * 保存登录用户
     */
    public static void setLoginInfo(LoginInfo info){
        getSession().setAttribute(LOGININFO_IN_SESSION,info);
    }


    /**
     * 保存登录用户
     */
    public static LoginInfo getLoginInfo(){
        return (LoginInfo) getSession().getAttribute(LOGININFO_IN_SESSION);
    }


    /**
     * 获取ip
     */
    public static  String getIpLog(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return request.getRemoteAddr();
    }

}
