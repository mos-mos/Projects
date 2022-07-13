package com.farm.service.impl;

import com.farm.mapper.UserMapper;
import com.farm.model.SysUser;
import com.farm.page.PageResult;
import com.farm.page.QueryPageBean;
import com.farm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.farm.servict.impl
 * @Author: mos
 * @CreateTime: 2022-07-08  09:29
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        PageResult result = new PageResult();
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        int findCurrentPage = (currentPage - 1) * pageSize;
        List<SysUser> userList = userMapper.findPage(findCurrentPage, pageSize);
        streamUsers(userList);
        long total = userMapper.total();
        result.setTotal(total);
        result.setRows(userList);
//        PageHelper.startPage(currentPage, pageSize);
        return result;
    }

    public void streamUsers(List<SysUser> userList){
        userList.stream().forEach(user -> {
            user.setSex(user.getSex() == 0 ? '女' : '男');
        });

    }

    @Override
    public List<SysUser> findAll() {
        List<SysUser> userList = userMapper.selectSysUserAll();
        return userList;
    }

    @Override
    public SysUser findById(int id) {
        SysUser sysUser = userMapper.selectSysUserById((long) id);
        return sysUser;
    }

    @Override
    @Transactional
    public int deleteById(int id) {
        int row = userMapper.deleteSysUserById((long) id);
        return row;
    }

    @Override
    @Transactional
    public int addUser(SysUser sysUser) {
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        int user = userMapper.insertSysUser(sysUser);
        return user;
    }

    @Override
    @Transactional
    public int edit(SysUser sysUser) {
        sysUser.setUpdateTime(new Date());
        int row = userMapper.updateSysUser(sysUser);
        return row;
    }
}
