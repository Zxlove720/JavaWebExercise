package com.wzb.interceptor;

import com.wzb.utils.JWTUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws  Exception {

        // 获取URL，如果是登录，那么放行
        String url = request.getRequestURL().toString();
        if (url.contains("/login")) {
            log.info("登录请求，放行...");
            return true;
        }

        // 获取token
        String token = request.getHeader("token");

        // 如果token为null，表示未登录，返回401
        if (token == null || token.isEmpty()) {
            log.info("未登录，不放行");
            response.setStatus(401);
            return false;
        }

        // 解析token，如果无法解析，说明token错误，登录失败，返回401
        try {
            JWTUtils.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("token解析失败，登录失败，不放行");
            response.setStatus(401);
            return false;
        }

        // 如果token解析成功，说明登录成功，可以放行
        log.info("token成功解析，登录成功，放行");
        return true;
    }
}
