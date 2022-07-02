package com.wbt;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author 15236
 */
@SpringBootApplication
@MapperScan("com.wbt.mapper")
public class SecurityQuickStartApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(SecurityQuickStartApplication.class, args);
        System.out.println(run);
    }

}
