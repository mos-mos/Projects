package com.batch.model;

import lombok.Data;

import java.util.Date;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.batch.model
 * @Author: mos
 * @CreateTime: 2022-07-07  10:59
 * @Description: user实体类
 * @Version: 1.0
 */
@Data
public class User {
    private int id;
    private String username;
    private String pwd;
    private int sex;
    private Date birthday;
}
