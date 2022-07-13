package com.farm.service;

import com.farm.model.Permission;

import java.util.List;


public interface PermissionService {
    List<Permission> findAll(int id);
}
