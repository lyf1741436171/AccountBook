package cn.wolfcode.accountbook.interceptor;

import cn.wolfcode.accountbook.base.annotation.NeedLogin;
import cn.wolfcode.accountbook.base.domain.LoginInfo;
import cn.wolfcode.accountbook.util.UserContext;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录检查拦截器
 */
@Component
public class CheckLoginInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取当前拦截到将要请求的方法
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            //判断这个方法上是否贴有@NeedLogin注解
            boolean methodAnnotation = handlerMethod.hasMethodAnnotation(NeedLogin.class);
            LoginInfo loginInfo = UserContext.getLoginInfo();
            if (methodAnnotation && loginInfo == null) {
                //如果没有登录则跳转到登录页面
                response.sendRedirect("/login.html");
                return false;
            }
        }
        //否者放行
        return true;
    }
}
