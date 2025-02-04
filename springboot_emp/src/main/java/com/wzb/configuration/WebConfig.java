package com.wzb.configuration;

import com.wzb.interceptor.DemoInterceptor;
import com.wzb.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置类，配置Interceptor拦截器
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 定义需要配置的拦截器对象
    private final LoginInterceptor loginInterceptor;

    @Autowired
    public WebConfig(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册自定义拦截器对象
       registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login"); // 设置拦截路径
    }
}
