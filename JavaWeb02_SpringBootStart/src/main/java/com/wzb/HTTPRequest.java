package com.wzb;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 使用@RequestController将该类设置为请求处理类
@RestController
public class HTTPRequest {

    // HTTP的请求协议

        // 请求数据格式
        /*
        请求行
        请求数据的第一行，包含请求方式、资源路径、协议及版本
         */

        /*
        请求头
        从请求数据的第二行，以key: value的格式
        常见的请求头
        Host：请求的主机名，如：localhost:8080（Tomcat服务器的默认端口号）

        User-Agent：发起请求的浏览器版本；例如：Chrome的浏览器标识类似Mozilla/5.0...Chrome/79
        ；IE的浏览器的标识符类似Mozilla/5.0（Windows NT ...） like Gecko

        Accept：表示浏览器能够接收的数据类型，如：Application/json（json），text/*（文本），image/*（图片），* /*表示所有类型

        Accept-Language：表示浏览器偏好的语言，服务器可以据此返回不同语言的网页（zh-CN是中文；EN是英文）

        Accept-Encoding：表示浏览器支持的压缩类型，如：gzip，deflate等

        只有Post方式的请求才有请求体，Get方式请求是没有请求体的
        Content-Type：请求主体的数据类型，比如application/json;charset=UTF-8（UTF-8的json数据）

        Content-Length：请求主体的大小（字节）
         */

        /*
        请求体
        和请求头之间间隔了一个空行
        必须是Post方式的请求才有请求体，用于存放请求参数，Post请求的大小是没有限制的（一般是json数据格式）
        Get方式请求的参数是在请求行中的（直接在请求的资源路径后面拼接），是有大小限制的
         */

    /**
     * 操作HttpServletRequest类获取请求数据
     * @param request
     * @return
     */
    @RequestMapping("/request")
    public String request(HttpServletRequest request) {
        /*
         HTTP协议——请求数据的获取
         Web服务器（Tomcat）对HTTP协议的请求数据进行解析，并将其封装到了HttpServletRequest中，在调用Controller
         方法的时候，将其传递给了该方法，使得程序员不用直接对协议进行操作，只关注于项目的业务逻辑处理

         在程序中可以通过HTTPServletRequest中的方法获取HTTP的请求数据
        */

        // 1.获取请求参数（假如说参数有name和age）
        String name = request.getParameter("name"); // 需要传入参数名即可
        String age = request.getParameter("age");
        System.out.println("name=" + name + " age=" + age);

        // 2.获取请求路径uri和url     url是完整的请求路径 uri是资源的访问路径
        String uri = request.getRequestURI();
        String url = request.getRequestURL().toString(); // 原始的类型是StringBuffer，需要使用toString方法转换为String

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

        return "request success";

    }
}
