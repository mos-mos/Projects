package com.construction.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.construction.mapper.DevelopMapper;
import com.construction.mapper.ProjectMapper;
import com.construction.model.Developer;
import com.construction.model.Project;
import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;
import com.construction.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private DevelopMapper developMapper;

    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return
     */
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {

        PageResult result = new PageResult();
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        Page<Project> page = new Page<>(currentPage, pageSize);
        QueryWrapper<Project> queryWrapper = new QueryWrapper<>();
        if (queryString != null && queryString.length() > 0) {
            queryWrapper.eq("pid", queryString).or();
            queryWrapper.like("pName", queryString);
        }
        queryWrapper.eq("did",developMapper.selectById("${did})"));
        queryWrapper.eq("status", 1);
        Page<Project> lists = projectMapper.selectPage(page, queryWrapper);
        long total = lists.getTotal();
        List<Project> list = lists.getRecords();

        for (Project l : list) {
            Developer did = developMapper.selectById(l.getDid());
            l.setDeveloper(did);
        }
        result.setRows(list);
        result.setTotal(total);
        return result;
    }

    @Override
    public PageResult findPageById(QueryPageBean queryPageBean) {
        PageResult result = new PageResult();
        Integer currentPage = queryPageBean.getCurrentPage(); //当前页
        Integer pageSize = queryPageBean.getPageSize();//每页大小
        //total 总记录数
        List<Project> page = projectMapper.findPage((currentPage-1)*pageSize, pageSize);
        //rows  当前页的数据
        Long count = projectMapper.count();
        result.setRows(page);
        result.setTotal(count);
        return result;
    }

    @Override
    @Transactional  //增删改需要事务管理
    public int addProject(Project project) {
        if (project.getPName() != null) {
            project.setUpdateTime(new Date());
            System.out.println(project.toString());
            int insert = projectMapper.insert(project);
            return insert;
        }
        return 0;
    }


}
