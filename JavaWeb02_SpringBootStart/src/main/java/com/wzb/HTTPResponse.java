package com.wzb;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HTTPResponse {
    // HTTP的响应协议
        // 响应数据格式
        /*
        响应行
        响应数据的第一行，包括协议、状态码、描述
         */

        /*
        响应头
        从响应数据格式的第二行开始，也是以key:value的格式
         */

        /*
        响应体
        和响应头之间有一个空行，是响应数据格式的最后一部分，用于存放响应的数据
         */

        /*
        常见响应状态码：
        1XX：表示响应中，是临时的状态码；表示请求已经接收了，告诉客户端应该继续请求或客户端已经完成则可以忽略（常见于WebSocket技术）
        2XX：成功，该请求已经被成功接收，并且也成功处理
        3XX：重定向，重定向到其他地方了，让客户端再次发起一次请求可以完成整个处理
            比如：请求百度：http://www.baidu.com，百度的请求路径是https://www.baidu.com，但是请求也会成功
            是因为第一次请求http的时候，百度的服务器能够接收，会响应一个307状态码，告诉浏览器需要重定向访问正确的
            百度，并且会在响应头中添加Location:https://www.baidu.com这个响应头，浏览器就会根据这个响应的location
            再次发起请求，这次就会成功请求到正确的百度
            在重定向中，一共有两次请求响应的过程，第一次是请求到了错误的路径，但是服务器成功接收，返回3XX的状态码和
            在请求头中添加Location:（正确的路径）;浏览器看到状态码是3XX，就会根据Location的路径发起第二次请求，
            但是都是由浏览器在极短的时间内完成的，用户无法察觉
        4XX：客户端的错误，处理发生错误，责任在于客户端。如：请求了不存在的资源、客户端未被授权、禁止访问等
        5XX：服务器错误，处理发生错误，责任在于服务端。如：客户端程序抛出了异常（500就是服务器端抛异常了）
         */

    /**
     * 和request请求一样，Tomcat服务器也将响应的数据封装成了HttpServletResponse对象，
     * 可以操作HttpServletResponse对象便捷的封装响应的数据
     * @param response
     */
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws Exception {
        /* 虽然方法的本身没有返回值，但是对于response这个对象的设置、封装数据等操作都填充了需要返回的内容，
        最后，服务器会将整个HttpServletResponse对象响应给客户端，不需要返回值（即使没有操作该对象也会返回） */

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
     * @return
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
