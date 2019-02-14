package cn.wolfcode.accountbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 后台应用的主程序配置类
 */
@SpringBootApplication
@PropertySource("classpath:application-mgrsite.properties")
@Import(ApplicationCoreConfig.class)
@EnableScheduling
public class ApplicationMgrSiteConfig {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMgrSiteConfig.class, args);
    }
}
