package com.construction.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.construction.model.Project;
import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;

public interface ProjectService extends IService<Project> {


    PageResult findPageById(QueryPageBean queryPageBean);
    Page<Project> findPage(QueryPageBean queryPageBean);

    int addProject(Project project);

    int editProject(Project project);

    int deleteProject(Integer pid);

    int bandDid(String did,Integer[] pids);
}
