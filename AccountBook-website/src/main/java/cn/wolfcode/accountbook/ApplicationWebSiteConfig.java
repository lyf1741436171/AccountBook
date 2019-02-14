package cn.wolfcode.accountbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * 前台应用的主程序配置类
 */
@SpringBootApplication
@PropertySource("classpath:application-website.properties")
@Import(ApplicationCoreConfig.class)
public class ApplicationWebSiteConfig {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationWebSiteConfig.class, args);
    }
}
