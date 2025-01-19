package com.wzb.controller.test;

import com.wzb.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于演示Cookie技术的Controller
 */
@Slf4j
@RestController
public class CookieController {

    /**
     * 设置Cookie
     * @param response springboot自动封装的响应对象
     * @return Result<Void>
     */
    @GetMapping("/c1")
    public Result<Void> setCookie(HttpServletResponse response) {
        response.addCookie(new Cookie("login_username", "wzb"));
        return Result.success();
    }

    /**
     * 获取Cookie
     * @param request springboot自动将请求数据封装的请求对象
     * @return Result<Void>
     */
    @GetMapping("/c2")
    public Result<Void> getCookie(HttpServletRequest request) {
        // 请求中可能会有很多Cookie，所以说是得到的Cookie数组
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login_username")) {
                log.info("login_user: {}", cookie.getValue());
            }
        }
        return Result.success();
    }
}
