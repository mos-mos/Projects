package com.farm.controller;

import com.farm.constants.NodeId;
import com.farm.model.Permission;
import com.farm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @GetMapping("findAll")
    public List<Permission> findAll(){
        List<Permission> all = permissionService.findAll(NodeId.ROOTNODE.getNode());
        return all;
    }
}