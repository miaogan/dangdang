package com.ac.dang_dang.Interceptor;

import com.ac.dang_dang.entity.TUser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取 session 中的用户信息
        Object userObj = request.getSession().getAttribute("user");
        String url = request.getRequestURI();
        // 不拦截验证码请求
        if (url.contains("/user/image")) {
            return true;
        }
        if (userObj == null || !(userObj instanceof TUser)) {
            // 用户未登录，跳转到登录页面
            response.sendRedirect("/login.html");
            return false;
        } else {
            // 用户已登录，放行
            return true;
        }
    }
}