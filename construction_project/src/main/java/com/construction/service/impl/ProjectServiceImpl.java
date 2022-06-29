package com.construction.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.construction.mapper.ContractMapper;
import com.construction.mapper.DevelopMapper;
import com.construction.mapper.ProjectMapper;
import com.construction.model.Contractor;
import com.construction.model.Developer;
import com.construction.model.Project;
import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;
import com.construction.service.ProjectService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Wang Zero
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private DevelopMapper developMapper;

    @Autowired
    private ContractMapper contractMapper;

    /**
     * @description:
     * @author: mos Wang Zero
     * @param: queryPageBean
     * @return: com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.construction.model.Project>
     * @Date: 2022/6/28 15:14
     * @Version 1.0.0
     */

    @Override
    public Page<Project> findPage(QueryPageBean queryPageBean) {

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
//        queryWrapper.eq("did",developMapper.selectById("${did})"));
        queryWrapper.eq("status", 1);
        Page<Project> lists = projectMapper.selectPage(page, queryWrapper);
//        long total = lists.getTotal();
//        List<Project> list = lists.getRecords();

        for (Project list : lists.getRecords()) {
            QueryWrapper<Developer> dev = new QueryWrapper<>();
            dev.eq("status",1).eq("did",list.getDid());
            Developer did = developMapper.selectOne(dev);
            QueryWrapper<Contractor> con = new QueryWrapper<>();
            con.eq("status",1).eq("cid",list.getCid());
            Contractor cid = contractMapper.selectOne(con);
            list.setDeveloper(did);
            list.setContractor(cid);
        }
//        result.setRows(list);
//        result.setTotal(total);

//        return result;
        return lists;
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

    @Override
    @Transactional
    public int editProject(Project project) {
        project.setUpdateTime(new Date());
        int row = projectMapper.updateById(project);
        return row;
    }

    @Override
    public int deleteProject(Integer pid){
        Date date = new Date();
        System.out.println(date);
        int row = projectMapper.deleteByPid(pid, date);
        return row;
    }

    /**
     * @description: 给工程绑定did开发商
     * @author: mos / Wang Zero
     * @param: did
     * @param: pids
     * @Date: 2022/6/28 21:22
     * @Version 1.0.0
     */

    @Override
    @Transactional
    @Rollback
    public int bandDid(String did, Integer[] pids) {
        int row = -1;
        if (pids != null || pids.length > 0){
            for (Integer pid : pids) {
                Project project = new Project();
                project.setPid(pid);
                project.setDid(did);
                project.setUpdateTime(new Date());
                row = projectMapper.updateById(project);
            }
        }
        return row;
    }


}
