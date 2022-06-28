package com.construction.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@TableName("project")
public class Project {
    @TableId(value = "pid", type = IdType.AUTO)
    private Integer Pid;
    @TableField("pname")
    private String pName;
    @TableField("starttime")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startTime;
    @TableField("endtime")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
    private String did;
    private String cid;
    @TableField("updateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    //开发商实体属性 一对一

    @TableField(exist = false)
    private Developer developer;


}
