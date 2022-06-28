package com.construction.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("developer")
public class Developer {
    @TableId(value = "did", type = IdType.ASSIGN_UUID )
    private String did;
    @TableField("dname")
    private String dName;
    @TableField("updatetime")
    private Date udpateTime;
}
