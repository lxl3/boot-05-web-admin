package com.atguigu.admin.Service.impl;

import com.atguigu.admin.Service.AccountService;
import com.atguigu.admin.bean.Account;
import com.atguigu.admin.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
     @Autowired
     AccountMapper accountMapper;
     @Override
     public Account getacc(Integer id) {
         return accountMapper.getAccountById(id);
     }
}
