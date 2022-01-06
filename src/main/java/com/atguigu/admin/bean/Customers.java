package com.atguigu.admin.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("customers")
public class Customers {
    @TableId
    private Integer id;
    private String name;
    private String email;
    private Date birth;
    private String photo;

}
