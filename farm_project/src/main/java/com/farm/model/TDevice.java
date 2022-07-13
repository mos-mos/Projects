package com.farm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.farm.model
 * @Author: mos
 * @CreateTime: 2022-07-13  08:59
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class TDevice {
    /** 主键  */
    private Long id;

    /**  设备id编号  */
    private String sn;

    /**  设备呢称  */
    private String name;

    /**  类型  */
    private Long typeId;

    /**  设备归属的农场id  */
    private Long farmId;

    /**  设备的位置  */
    private String location;

    /**  设备图片  */
    private String image;

    /**  安装时间  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date installTime;

    /**  状态 ： 0 在线 1 离线  */
    private String state;

    /** 规格 */
    private String standard;

    /**  生产厂家  */
    private String manufacturer;

    /**  拥有者  */
    private Long userId;

    /**  设备软件版本号  */
    private String softwareVersion;

    /**  设备值的最小值  */
    private Long thresholdMin;

    /**  设备國值的最大值  */
    private Long thresholdMax;

    private String remark;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**  操作人员  */
    private String operator;

    private TDeviceType type;

    private TFarm farm;

    private SysUser sysUser;

}
