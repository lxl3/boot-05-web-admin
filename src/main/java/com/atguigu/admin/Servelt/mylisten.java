package com.atguigu.admin.Servelt;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@Slf4j
//@WebListener
public class mylisten implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("初始化成功");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("销毁");
    }
}
