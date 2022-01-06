package com.atguigu.admin.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Book {
    private Integer FlowID;
    private Integer customers;
    private String IDCard;
    private String ExamCard;
    private String StudentName;
    private String Location;
    private Integer Grade;
}
