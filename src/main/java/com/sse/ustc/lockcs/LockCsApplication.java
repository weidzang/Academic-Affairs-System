package com.sse.ustc.lockcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@ServletComponentScan
@ComponentScan(basePackages = "com")
//@EnableRedisRepositories
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class LockCsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LockCsApplication.class, args);
    }

}
