package com.wzb.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过Tomcat封装的HttpServletRequest对象操作请求数据
 */
@RestController
public class RequestController {
    /**
     * 通过Tomcat封装的HttpServletRequest对象操作请求数据
     * @param request HttpServletRequest对象
     */
    @RequestMapping("/request")
    public String request(HttpServletRequest request) {
         // 1.获取请求参数（假如说参数有name和age）
        String name = request.getParameter("name"); // 需要传入参数名即可
        String age = request.getParameter("age");
        System.out.println("name=" + name + " age=" + age);

        // 2.获取请求路径uri和url     url是完整的请求路径 uri是资源的访问路径
        String uri = request.getRequestURI();
        String url = request.getRequestURL().toString(); // 原始的类型是StringBuffer，需要使用toString方法转换为String
        System.out.println("uri是" + uri);
        System.out.println("url是" + url);


        // 3.获取请求头     User-Agent
        String userAgent = request.getHeader("User-Agent");
        System.out.println("userAgent = " + userAgent);

        // 4.获取请求方式
        String method = request.getMethod();
        System.out.println("请求方式是" + method);

        // 5.获取请求协议
        String protocol = request.getProtocol();
        System.out.println("请求协议是" + protocol);

        // 6.获取请求的查询字符串
        String queryString = request.getQueryString();
        System.out.println("请求的查询字符串是" + queryString);
        return "OK";
    }
}
