package com.wzb.controller.test;

import com.wzb.pojo.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于演示Session技术的Controller
 */
@Slf4j
@RestController
public class SessionController {

    /**
     * 创建Session
     * @param session 在服务端创建Session对象
     * @return Result<Void>
     */
    @GetMapping("/s1")
    public Result<Void> setSession(HttpSession session) {
        log.info("set-HttpSession: {}", session.hashCode());
        // 在session中存储数据
        session.setAttribute("login_user", "tom");
        return Result.success();
    }

    /**
     * 获取Session中数据
     * @param request 请求数据封装的对象
     * @return Result<Void>
     */
    @GetMapping("/s2")
    public Result<Object> getSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        log.info("get-HttpSession: {}", session.hashCode());

        Object loginUser = session.getAttribute("login_user");
        log.info("login_user: {}", loginUser);
        return Result.success(loginUser);
    }



}
