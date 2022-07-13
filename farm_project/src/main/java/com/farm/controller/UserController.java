package com.farm.controller;

import com.farm.model.SysUser;
import com.farm.page.PageResult;
import com.farm.page.QueryPageBean;
import com.farm.page.Result;
import com.farm.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.farm.controller
 * @Author: mos
 * @CreateTime: 2022-07-08  09:27
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("findUserAll")
    public List<SysUser> findAll() {
        List<SysUser> userList = userService.findAll();
        return userList;
    }

    @PostMapping("allPage")
    public PageResult addUser(@RequestBody QueryPageBean queryPageBean) {
        PageResult result = userService.findPage(queryPageBean);
        return result;
    }



    @GetMapping("findById")
    public Result findById(int id) {
//        System.out.println(id);
        SysUser sysUser = userService.findById(id);
        Result result = new Result();
        result.setMessage("fail");
        if (ObjectUtils.isNotEmpty(sysUser)) {
            result.setFlag(true);
            result.setData(sysUser);
            result.setMessage("success");
        }
        return result;
    }

    @PostMapping("add")
    public Result add(@RequestBody SysUser sysUser) {
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        int count = userService.addUser(sysUser);
        if (count>0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result edit(@RequestBody SysUser sysUser) {
        sysUser.setUpdateTime(new Date());
        int row = userService.edit(sysUser);

        if (row > 0) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(int id) {
        int result =  userService.deleteById(id);
        if (result>0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }
}
