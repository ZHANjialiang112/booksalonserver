//package com.zjl.booksalon.commons.interceptor;
//
//import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
///**
// * @Auther: ZJL
// * @Date: 2022/4/7 11:20
// * @Description:
// */
//@Configuration
//public class InterceptorConfig extends WebMvcConfigurationSupport {
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/base/**")
//                .excludePathPatterns("static/**");
//        super.addInterceptors(registry);
//    }
//}
