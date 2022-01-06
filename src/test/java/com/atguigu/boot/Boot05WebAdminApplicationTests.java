package com.atguigu.boot;

import com.atguigu.admin.bean.Account;
import com.atguigu.admin.bean.Customers;
import com.atguigu.admin.bean.Usertable;
import com.atguigu.admin.mapper.CustomerMapper;
import com.atguigu.admin.mapper.UserTablemapper;
import lombok.extern.slf4j.Slf4j;

import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;


import javax.sql.DataSource;
import java.util.List;

@Slf4j
@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.atguigu.admin")
class Boot05WebAdminApplicationTests {
    @Autowired
    DataSource dataSource;
    @Autowired
    UserTablemapper userTablemapper;
    @Autowired
    CustomerMapper customerMapper;
    @Test
    public void testCustomer(){
        Customers customers = customerMapper.selectById(1);
        System.out.println(customers);
    }
    @Test
    public void testusertable(){
        List<Usertable> getalluser = userTablemapper.getalluser();
        System.out.println(getalluser);
        Usertable aa = userTablemapper.getUserbyId("AA");
        System.out.println(aa);

    }

    @Test
    public void testdatasource(){
        System.out.println(dataSource.getClass());
    }

}
