package com.construction.vo;

import com.construction.model.Contractor;
import com.construction.model.Developer;
import lombok.Data;
import lombok.ToString;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.construction.vo
 * @Author: mos
 * @CreateTime: 2022-06-28  20:38
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@ToString
public class ConProVo extends Contractor {
    private Integer[] pids;
}
