package com.construction.dto;

import com.construction.model.Developer;
import lombok.Data;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.construction.dto
 * @Author: mos
 * @CreateTime: 2022-06-29  10:36
 * @Description:
 * @Version: 1.0
 */
@Data
public class DeveloperDto extends Developer {
    int[] pids;
}
