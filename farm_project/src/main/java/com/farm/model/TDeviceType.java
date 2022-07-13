package com.farm.model;

import lombok.Data;

import java.util.Date;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.farm.model
 * @Author: mos
 * @CreateTime: 2022-07-13  10:25
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class TDeviceType {
    /** 设备主键 */
    private Long id;

    /** 设备名称 */
    private String name;

    /** 描述 */
    private String description;

    private String remark;
    /** 操作人员 */
    private String operator;

    private Date createTime;

    private Date updateTime;

}
