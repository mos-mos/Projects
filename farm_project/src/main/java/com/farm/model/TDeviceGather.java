package com.farm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.farm.model
 * @Author: mos
 * @CreateTime: 2022-07-13  10:30
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class TDeviceGather {
    /** 设备采集数据主键 */
    private Long id;

    /** 采集的设备id */
    private Long deviceId;

    /** 设备唯一序列号 */
    private String deviceSn;

    /** 设备名称 */
    private String deviceName;

    /**  传感器类型 */
    private String deviceType;

    /** 采集的数据 */
    private Long basicData;

    /** 计量单位id,不同的传感器有不同的单位 */
    private Long measurementUnitId;

    /** 计量单位 */
    private String measurementUnitName;

    /** 单位类型 */
    private String measureUnitType;

    /** 采集时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date gatherTime;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
