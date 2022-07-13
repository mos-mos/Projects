package com.construction.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.construction.dto.BranchDto;
import com.construction.mapper.TaskPlanMapper;
import com.construction.model.Branch;
import com.construction.model.Project;
import com.construction.model.TaskPlan;
import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;
import com.construction.page.Result;
import com.construction.service.BranchService;
import com.construction.service.TaskPlanService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.construction.service.impl
 * @Author: mos
 * @CreateTime: 2022-07-06  08:32
 * @Description: 任务计划--service层
 * @Version: 1.0
 */
@Service
public class TaskPlanServiceImpl extends ServiceImpl<TaskPlanMapper, TaskPlan> implements TaskPlanService {

    @Autowired
    private TaskPlanMapper taskPlanMapper;
    @Autowired
    private BranchService branchService;

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        PageResult pageResult = new PageResult();
        Integer pageSize = queryPageBean.getPageSize();
        Integer currentPage = queryPageBean.getCurrentPage();
        String queryString = queryPageBean.getQueryString();
        Page<TaskPlan> page = new Page<>(currentPage, pageSize);
        QueryWrapper<TaskPlan> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1);
        if (ObjectUtils.isNotEmpty(queryString)) {
            queryWrapper.like("bName", queryString);
        }
        Page<TaskPlan> pages = taskPlanMapper.selectPage(page, queryWrapper);
        List<TaskPlan> list = pages.getRecords();
        for (TaskPlan taskPlan : list) {
            if (ObjectUtils.isNotEmpty(taskPlan.getTid())) {
                Branch branch = branchService.findBranch(taskPlan.getBid());
                taskPlan.setBranch(branch);
            }
        }
        long total = pages.getTotal();
        pageResult.setTotal(total);
        pageResult.setRows(list);
        return pageResult;
//        return null;
    }

    @Override
    public int addAndBind(TaskPlan taskPlan) {
        taskPlan.setUpdateTime(new Date());
        int insert = taskPlanMapper.insert(taskPlan);
        return insert;
    }

    @Override
    public Result bindAndEdit(TaskPlan taskPlan) {
        taskPlan.setUpdateTime(new Date());
        int row = taskPlanMapper.updateById(taskPlan);
//        int unBindCid = projectService.unBindCid(contractor.getCid());
//        int bindCid = projectService.bindCid(conProVo.getCid(), conProVo.getPids());
        if (row > 0 ) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @Override
    public Result deleteByTid(String tid) {
        int update = taskPlanMapper.deleteByTid(tid);
        if (update > 0) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @Override
    public Result findByTid(String tid) {
//        BranchDto branchDto = taskPlanMapper.findBySidDto(tid);
//        List<Project> list = projectService.findList();
//        int[] pids = null;
//        if (ObjectUtils.isNotEmpty(list)) {
//            pids = new int[list.size()];
//            for (int i = 0; i < list.size(); i++) {
//                pids[i] = list.get(i).getPid();
//            }
//        } else {
//            pids = new int[0];
//        }
//        branchDto.setPids(pids);
//        Result result = new Result();
//        result.setMessage("fail");
//        if (ObjectUtils.isNotEmpty(branchDto)) {
//            result.setData(branchDto);
//            result.setFlag(true);
//            result.setMessage("success");
//        }
//        return result;
        return null;
    }
}
