package cn.wolfcode.accountbook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * core 核心配置类
 */
@SpringBootApplication
@MapperScan("cn.wolfcode.accountbook.*.mapper")
@EnableTransactionManagement
public class ApplicationCoreConfig
{
}
