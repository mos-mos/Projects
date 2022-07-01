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
 * @CreateTime: 2022-06-30  15:02
 * @Description: 开发商部门实体类
 * @Version: 1.0
 */
@Data
@TableName("branch")
public class Branch {
    @TableId(value = "bid", type = IdType.ASSIGN_UUID)
    private String bid;
    @TableField("bname")
    private String bName;
    @TableField("pid")
    private Integer pid;
    @TableField("updatetime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @TableField(exist = false)
    private Project project;
}
