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
 * @CreateTime: 2022-06-30  08:51
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@TableName("stage")
public class Stage {
    @TableId(value = "sid", type = IdType.ASSIGN_UUID )
    private String sid;
    @TableField("sname")
    private String sName;
    @TableField("starttime")
    private Date startTime;
    @TableField("endtime")
    private Date endTime;
    @TableField("pid")
    private Integer pid;
    @TableField("updatetime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @TableField(exist = false)
    private Project project;
}
