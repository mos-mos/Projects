package com.thymeleaf.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_user")
public class User {
    @TableId(value = "ID",type = IdType.AUTO)
    private Integer id;
    @TableField("USER_NAME")
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private String email;

}
