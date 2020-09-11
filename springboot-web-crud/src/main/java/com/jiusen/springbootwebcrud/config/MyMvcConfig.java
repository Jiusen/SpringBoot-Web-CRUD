package com.jiusen.springbootwebcrud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//使用
@Configuration
public class MyMvcConfig implements WebMvcConfigurer
{
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/success").setViewName("success");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        System.out.println("123");
    }

}