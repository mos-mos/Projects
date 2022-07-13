package com.construction.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.construction.model
 * @Author: mos
 * @CreateTime: 2022-07-06  08:21
 * @Description: 任务计划表
 * @Version: 1.0
 */
@Data
@TableName("taskplan")
public class TaskPlan {
    @TableId(value = "tid", type = IdType.ASSIGN_UUID)
    private String tid;
    @TableField("tname")
    private String tName;
    @TableField("starttime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @TableField("endtime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    @TableField("bid")
    private String bid;
    @TableField("updatetime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    // 一对一
    private Branch branch;
}
