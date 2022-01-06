package com.atguigu.admin.Service.impl;

import com.atguigu.admin.Service.CustomersService;
import com.atguigu.admin.bean.Customers;
import com.atguigu.admin.mapper.CustomerMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CustomersServiceImpl extends ServiceImpl<CustomerMapper,Customers> implements CustomersService {
}
