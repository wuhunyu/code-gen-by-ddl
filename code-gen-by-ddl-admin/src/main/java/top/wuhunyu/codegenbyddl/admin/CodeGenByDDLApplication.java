package top.wuhunyu.codegenbyddl.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 代码生成器 主启动类
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2023/2/13 22:36
 */

@Slf4j(topic = "主启动类")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CodeGenByDDLApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CodeGenByDDLApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("代码生成器 启动成功");
    }
}
