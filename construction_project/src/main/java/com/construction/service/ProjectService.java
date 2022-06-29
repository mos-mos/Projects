package com.construction.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.construction.model.Project;
import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;

import java.util.List;

public interface ProjectService extends IService<Project> {


//    PageResult findPageById(QueryPageBean queryPageBean);
    Page<Project> findPage(QueryPageBean queryPageBean);

    int addProject(Project project);

    int editProject(Project project);

    int deleteProject(Integer pid);

    int unBindDid(String did);
    int bindDid(String did,Integer[] pids);
    int unBindCid(String cid);
    int bindCid(String cid,Integer[] pids);

    List<Project> findByDid(String did);
    List<Project> findByCid(String cid);

//    void updateByPid(String did , int[] pids);
}
