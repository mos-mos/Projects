package com.farm.service.impl;

import com.farm.mapper.PermissionMapper;
import com.farm.model.Permission;
import com.farm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> findAll(int id) {
        List<Permission> list = permissionMapper.findAll(id);

        for (Permission permission : list) {
            List<Permission> children =  new ArrayList<>();
            //通过递归的查询
            children=findAll(permission.getId());
            permission.setChildren(children);
        }
        System.out.println(list);
        return list;
    }
}
