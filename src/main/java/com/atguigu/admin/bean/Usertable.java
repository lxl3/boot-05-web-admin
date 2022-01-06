package com.atguigu.admin.bean;

//import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName("user_table")
public class Usertable {
    private String user;
    private String password;
    private Integer balance;
}
