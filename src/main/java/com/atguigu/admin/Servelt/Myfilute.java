package com.atguigu.admin.Servelt;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@Slf4j
//@WebFilter(urlPatterns = {"/css/*","/images/*"})
public class Myfilute implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter初始化成功");
    }

    @Override
    public void destroy() {
        log.info("filter销毁");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("filter工作");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
