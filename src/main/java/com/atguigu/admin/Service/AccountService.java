package com.atguigu.admin.Service;

import com.atguigu.admin.bean.Account;

import org.springframework.stereotype.Service;

@Service
public interface AccountService {
     Account getacc(Integer id);
     //void saveacc(Account account);
}
