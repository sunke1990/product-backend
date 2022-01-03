package com.back.productbackend.global;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author sunke
 * @DATE 2022/1/1
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Resource
    private AuthenticationInterceptor authenticationInterceptor;

    @Resource
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .order(1)
                .excludePathPatterns("/role/add")
                .excludePathPatterns("/user/add")
                .excludePathPatterns("/user/role/add")
                .addPathPatterns("/**");

        registry.addInterceptor(authenticationInterceptor)
                .order(2)
                .excludePathPatterns("/role/add")
                .excludePathPatterns("/user/add")
                .excludePathPatterns("/user/role/add")
                .addPathPatterns("/**");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
