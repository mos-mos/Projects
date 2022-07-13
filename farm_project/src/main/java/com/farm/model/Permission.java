package com.farm.model;

import lombok.Data;

import java.util.List;
@Data
public class Permission {
    private int id;
    private String path;
    private String title;
    private String icon;
    private String linkUrl;
    private List<Permission> children;  //子菜单 //数据库描述集合关系 做一对多
    // private Permission permission;  //单表做一对一
}