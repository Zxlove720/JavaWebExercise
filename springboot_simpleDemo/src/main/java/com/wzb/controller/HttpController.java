package com.wzb.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HttpController {
    @RequestMapping("response")
    public void response(HttpServletResponse response) throws IOException {
        // 设置响应状态码
        response.setStatus(302);
        // 设置响应头
        response.setHeader("Location", "https://www.baidu.com");
        // 设置响应体
        // 响应体需要使用流写入，HttpServletResponse中自带IO流，打开后就可以直接写
        response.getWriter().write("<h1>Hello Response<h1>");
    }

    /**
     * 除了Tomcat服务器的封装，Spring提供了操作响应数据的对象ResponseEntity，可以通过ResponseEntity对象
     * 更加便捷的操作响应数据
     *
     * @return ResponseEntity
     */
    @RequestMapping("/response2")
    public ResponseEntity<String> response() {
        return ResponseEntity.status(307)
                .header("Location", "https://www.baidu.com")
                .body("<h1>Spring Response<h1>");
    }
    // 但是需要注意的是：响应状态码（status）和响应头（header）没有特殊要求的话，通常不手动设置
    // 服务器会根据请求处理的逻辑自动设置响应状态码和响应头
}
