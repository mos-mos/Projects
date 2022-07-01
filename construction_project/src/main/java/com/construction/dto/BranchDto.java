package com.construction.dto;

import com.construction.model.Stage;
import lombok.Data;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.construction.dto
 * @Author: mos
 * @CreateTime: 2022-06-30  08:56
 * @Description:
 * @Version: 1.0
 */
@Data
public class BranchDto extends Stage {

    int[] pids;
}
