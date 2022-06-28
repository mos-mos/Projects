package com.construction.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.construction.model.Project;
import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;

public interface ProjectService extends IService<Project> {


    PageResult findPageById(QueryPageBean queryPageBean);
    PageResult findPage(QueryPageBean queryPageBean);

    int addProject(Project project);
}
