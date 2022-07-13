package com.farm.model;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.farm.model
 * @Author: mos
 * @CreateTime: 2022-07-12  11:47
 * @Description: 农产品
 * @Version: 1.0
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ProductBatches {
    /** 主键ID */
    private Long id;

    /** 作物名称 */
    private String productName;

    /** 是否启用 */
    private String isActive;

    /** 产品批次 */
    private String productBatch;

    /** 面积 */
    private Long area;

    /** 采收时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date recoveryDate;

    /** 产品图片 */
//    private String img;

    /** 产品特点 */
    private String feature;

    /** 基地id */
    private Long sysUserId;

    /** 农场id */
    private Long farmId;

    private SysUser sysUser;

    private TFarm tFarm;
}
