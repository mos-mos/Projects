package com.scheduled.controller;

import com.scheduled.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "用户模块接口",tags = "user用户模块")
@RestController
@RequestMapping("user")
public class UserController {

    @ApiOperation(value = "查询员工", notes = "根据ID查询员工", response = User.class)
    @GetMapping("/{id}")
    @ApiImplicitParam
    public User getUser(@PathVariable int id){
        System.out.println("jinrule ");
        return new User(id,"aaa","bbb","ccc",18,"aa@qq.com");
    }
}
