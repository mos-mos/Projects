package com.farm.model;

import lombok.Data;

import java.util.Date;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.farm.model
 * @Author: mos
 * @CreateTime: 2022-07-09  09:08
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class TFarm {
    /** 基地主键 */
    private Long id;
    /** 省份 */
    private String province;
    /** 城市 */
    private String city;
    /** 区域  */
    private String district;
    /**  基地类型  */
    private String type;
    /**  基地名称  */
    private String name;
    /**  基地负责人  */
    private String linkman;
    /**  手机号  */
    private String telephone;
    /**  备注  */
    private String remark;
    /**  创建时间  */
    private Date createTime;
    /**  修改时间  */
    private Date updateTime;
    /** 外键；用户表id*/
    private Long userId;
    /** 主要农作物 */
    private String mainCrop;
    /** 面积 */
    private Long area;
    /** 图片  */
    private Long img;

    /**  one by one  */
    private SysUser sysUser;
}
