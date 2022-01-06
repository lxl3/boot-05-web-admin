package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.Customers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CustomerMapper extends BaseMapper<Customers> {

}
