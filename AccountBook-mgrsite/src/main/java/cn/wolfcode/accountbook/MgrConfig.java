package cn.wolfcode.accountbook;


import cn.wolfcode.accountbook.interceptor.MgrCheckLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 对springmvc配置
 */
@Component
public class MgrConfig implements WebMvcConfigurer {
    @Autowired
    private MgrCheckLoginInterceptor mgrCheckLoginInterceptor;

    /*
     * 注册拦截器
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mgrCheckLoginInterceptor).addPathPatterns("/**");
    }

}
