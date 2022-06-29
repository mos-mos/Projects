package com.construction.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("contractor")
public class Contractor {
    @TableId(value = "cid",type = IdType.ASSIGN_UUID)
    private String cid;
    @TableField("cname")
    private String cName;
    @TableField("updatetime")
    private Date updateTime;


}
