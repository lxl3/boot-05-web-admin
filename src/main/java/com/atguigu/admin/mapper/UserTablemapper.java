package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.Usertable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Mapper
@Repository
public interface UserTablemapper {
    @Select("select * from user_table")
    List<Usertable> getalluser();
    Usertable  getUserbyId(String id);
}
