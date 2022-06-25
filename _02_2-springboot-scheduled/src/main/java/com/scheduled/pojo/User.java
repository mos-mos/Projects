package com.scheduled.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "用户实体",description = "描述用户")
public class User {
    @ApiModelProperty(value = "id属性",name = "主键")
    private int id;
    private String userName;
    private String password;
    private String name;
    private int age;
    private String email;
}
