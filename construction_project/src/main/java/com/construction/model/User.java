package com.construction.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.construction.model
 * @Author: mos
 * @CreateTime: 2022-07-01  09:47
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@TableName("user")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private String username;
    private String password;
    @TableField("creattime")
    private Date creatTime;
    @TableField("realname")
    private String realName;
}
