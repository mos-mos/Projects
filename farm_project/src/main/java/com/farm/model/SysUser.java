package com.farm.model;

import lombok.Data;

import java.util.Date;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.farm.model
 * @Author: mos
 * @CreateTime: 2022-07-08  08:56
 * @Description: 用户表
 * @Version: 1.0
 */
@Data
public class SysUser {
    private int id;
    private String username;
    private String password;
    private String salt;
    private String nickname;
    private String headImgUrl;
    private String phone;
    private String telephone;
    private String email;
    private Date birthday;
    private char sex;
    private Date createTime;
    private Date updateTime;
}
