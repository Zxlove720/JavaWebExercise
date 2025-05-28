package com.wzb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wzb.mapper")
public class JavaWeb13MyBatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaWeb13MyBatisPlusApplication.class, args);
    }

}
