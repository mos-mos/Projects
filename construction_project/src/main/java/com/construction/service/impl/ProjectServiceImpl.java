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
import com.construction.page.QueryPageBean;
import com.construction.service.ProjectService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
            Developer developer = getDeveloper(list.getDid());
            Contractor contractor = getContractor(list.getCid());
            list.setDeveloper(developer);
            list.setContractor(contractor);
        }
//        result.setRows(list);
//        result.setTotal(total);
//        return result;
        return lists;
    }

    public Developer getDeveloper(String did) {
        QueryWrapper<Developer> dev = new QueryWrapper<>();
        dev.eq("status", 1).eq("did", did);
        Developer developer = developMapper.selectOne(dev);
        return developer;
    }

    public Contractor getContractor(String cid) {
        QueryWrapper<Contractor> con = new QueryWrapper<>();
        con.eq("status", 1).eq("cid", cid);
        Contractor contractor = contractMapper.selectOne(con);
        return contractor;
    }

    @Override
    public Project findProject(Integer id) {
        QueryWrapper<Project> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pid", id);
        queryWrapper.eq("status", 1);
        Project project = projectMapper.selectOne(queryWrapper);
        if (project != null ){
            if (ObjectUtils.isNotEmpty(project.getDid())) {
                Developer developer = getDeveloper(project.getDid());
                project.setDeveloper(developer);
            }
            if (ObjectUtils.isNotEmpty(project.getCid())) {
                Contractor contractor = getContractor(project.getCid());
                project.setContractor(contractor);
            }
        }
        return project;
    }

    @Override
    public List<Project> findByDid(String did) {
        QueryWrapper<Project> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("did", did);
        queryWrapper.eq("status", 1);
        List<Project> projects = projectMapper.selectList(queryWrapper);
        return projects;
    }


    @Override
    public List<Project> findByCid(String cid) {
        QueryWrapper<Project> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cid", cid);
        queryWrapper.eq("status", 1);
        List<Project> projects = projectMapper.selectList(queryWrapper);
        return projects;
    }

    @Override
    public List<Project> findList() {
        QueryWrapper<Project> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("pid", pid);
        queryWrapper.eq("status", 1);
        List<Project> projects = projectMapper.selectList(queryWrapper);
        return projects;
    }

    //    @Override
//    public PageResult findPageById(QueryPageBean queryPageBean) {
//        PageResult result = new PageResult();
//        Integer currentPage = queryPageBean.getCurrentPage(); //?????????
//        Integer pageSize = queryPageBean.getPageSize();//????????????
//        //total ????????????
//        List<Project> page = projectMapper.findPage((currentPage-1)*pageSize, pageSize);
//        //rows  ??????????????????
//        Long count = projectMapper.count();
//        result.setRows(page);
//        result.setTotal(count);
//        return result;
//    }

    @Override
    @Transactional  //???????????????????????????
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

//    @Override
//    public void updateByPid(String did , int[] pids) {
//
//        if (ObjectUtils.isNotEmpty(pids)){
//
//            for(int pid : pids){
//                int row = projectMapper.updateByPid(did,pid,new Date());
//            }
//        }
//    }

    @Override
    public int deleteProject(Integer pid) {
        Date date = new Date();
        System.out.println(date);
        int row = projectMapper.deleteByPid(pid, date);
        return row;
    }

    /**
     * @description: ?????????????????????
     * @author: mos / Wang Zero
     * @param: did
     * @param: pids
     * @Date: 2022/6/28 21:22
     * @Version 1.0.0
     */
    @Override
    @Transactional
    public int bindDid(String did, Integer[] pids) {
        int row = -1;
        if (ObjectUtils.isNotEmpty(pids)) {
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

    @Override
    @Transactional
    public int unBindDid(String did) {
        int row = -1;
        if (ObjectUtils.isNotEmpty(did)) {
            Project project = new Project();
            project.setDid("");
//                project.setDid(did);
            project.setUpdateTime(new Date());
            UpdateWrapper<Project> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("did", did);
            row = projectMapper.update(project, updateWrapper);

        }
        return row;
    }

    @Override
    @Transactional
    public int bindCid(String cid, Integer[] pids) {
        int row = -1;
        if (ObjectUtils.isNotEmpty(pids)) {
            for (Integer pid : pids) {
                Project project = new Project();
                project.setPid(pid);
                project.setCid(cid);
                project.setUpdateTime(new Date());
                row = projectMapper.updateById(project);
            }
        }
        return row;
    }

    @Override
    @Transactional
    public int unBindCid(String cid) {
        int row = -1;
        if (ObjectUtils.isNotEmpty(cid)) {
            Project project = new Project();
            project.setCid("");
//                project.setDid(did);
            project.setUpdateTime(new Date());
            UpdateWrapper<Project> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("cid", cid);
            row = projectMapper.update(project, updateWrapper);
        }
        return row;
    }


}
