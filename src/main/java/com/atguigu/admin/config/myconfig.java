package com.atguigu.admin.config;

import com.atguigu.admin.Interceptor.adminInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * 编写一个拦截器实现interceptor接口
 * 拦截器注册到容器中
 * 指定拦截器规则[如果是拦截所有，静态资源也会被拦截
 */
@Configuration
public class myconfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new adminInterceptor())
                .addPathPatterns("/**")//所有请求都被拦截，包括静态资源
                .excludePathPatterns("/","/login","/css/**","/js/**","/fonts/**","/images/**");
    }
}
