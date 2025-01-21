package com.wzb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan // Filter属于Servlet组件，spring框架需要使用该注解开启Servlet组件支持
public class SpringbootEmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootEmpApplication.class, args);
    }

}
