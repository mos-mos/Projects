package com.farm.service;

import com.farm.model.SysUser;
import com.farm.page.PageResult;
import com.farm.page.QueryPageBean;

import java.util.List;

public interface UserService {
    PageResult findPage(QueryPageBean queryPageBean);

    List<SysUser> findAll();

    SysUser findById(int id);

    int deleteById(int id);

    int addUser(SysUser sysUser);

    int edit(SysUser sysUser);
}
