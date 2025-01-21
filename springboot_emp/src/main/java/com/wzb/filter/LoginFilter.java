package com.wzb.filter;

import com.wzb.utils.JWTUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 令牌校验过滤器（登录过滤器）
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Init Filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        // 获取该请求的URL
        String url = httpServletRequest.getRequestURL().toString();

        // 判断该请求是否包含login，如果包含，说明该请求是登录，则放行
        if (url.contains("/login")) {
            log.info("login");
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        // 获取请求头中的token（JWT令牌）
        String jwt = httpServletRequest.getHeader("token");

        // 判断令牌是否存在，若不存在，则返回错误结果（未登录）
        if (jwt == null || jwt.isEmpty()) {
            log.info("JWT令牌为空，登录失败");
            httpServletResponse.setStatus(401);
            return;
        }

        // 解析JWT令牌，如果解析失败，则返回错误结果（未登录）
        try {
            JWTUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("JWT解析失败，登录失败");
            httpServletResponse.setStatus(401);
            return;
        }

        // 令牌解析成功，放行
        log.info("令牌解析成功，放行");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {
        log.info("Destroy Filter");
    }
}
