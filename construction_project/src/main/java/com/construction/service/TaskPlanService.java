package com.construction.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.construction.model.Branch;
import com.construction.model.TaskPlan;
import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;
import com.construction.page.Result;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.construction.service
 * @Author: mos
 * @CreateTime: 2022-07-06  08:32
 * @Description: TODO
 * @Version: 1.0
 */
public interface TaskPlanService extends IService<TaskPlan> {
    PageResult findPage(QueryPageBean queryPageBean);

    int addAndBind(TaskPlan taskPlan);

    Result bindAndEdit(TaskPlan taskPlan);

    Result deleteByTid(String tid);

    Result findByTid(String tid);
}
