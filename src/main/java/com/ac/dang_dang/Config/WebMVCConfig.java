package com.ac.dang_dang.Config;

import com.ac.dang_dang.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 75679
 */
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    private final LoginInterceptor loginInterceptor;

    public WebMVCConfig(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login", "/user/logout", "/user/register","/register.html","/login.html");
    }

}