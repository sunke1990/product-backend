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
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor)
                .order(1)
                .excludePathPatterns("/doc.html")
                .excludePathPatterns("/swagger-ui.html")
                .excludePathPatterns("/error")
                .excludePathPatterns("/console/getQRcodeId")
                .excludePathPatterns("/console/getQRcodeStatus")
                .excludePathPatterns("/role/add")
                .excludePathPatterns("/user/add")
                .addPathPatterns("/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
