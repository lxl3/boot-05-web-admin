package com.atguigu.admin.Servelt;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
public class MyregistConfig {
    @Bean
    public  ServletRegistrationBean myServlet(){
        myservelt myservelt = new myservelt();
        return new ServletRegistrationBean(myservelt,"/my","/my02");

    }
    public FilterRegistrationBean myfilter(){
        Myfilute myfilute = new Myfilute();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myfilute);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/css/*","/my"));
        return filterRegistrationBean;
        //return new FilterRegistrationBean(myfilute,myServlet());
    }
    public ServletListenerRegistrationBean mylisten(){
        mylisten mylisten = new mylisten();
        return new ServletListenerRegistrationBean(mylisten);
    }
}
