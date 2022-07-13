package com.construction.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.construction.dto.BranchDto;
import com.construction.dto.StageDto;
import com.construction.mapper.BranchMapper;
import com.construction.model.Branch;
import com.construction.model.Contractor;
import com.construction.model.Developer;
import com.construction.model.Project;
import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;
import com.construction.page.Result;
import com.construction.service.BranchService;
import com.construction.service.ProjectService;
import com.construction.utils.UUIDUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BranchServiceImpl extends ServiceImpl<BranchMapper, Branch> implements BranchService {
    @Autowired
    private BranchMapper branchMapper;
    @Autowired
    private ProjectService projectService;


    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        PageResult pageResult = new PageResult();
        Integer pageSize = queryPageBean.getPageSize();
        Integer currentPage = queryPageBean.getCurrentPage();
        String queryString = queryPageBean.getQueryString();
        Page<Branch> page = new Page<>(currentPage, pageSize);
        QueryWrapper<Branch> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1);
        if (ObjectUtils.isNotEmpty(queryString)) {
            queryWrapper.like("bName", queryString);
        }
        Page<Branch> pages = branchMapper.selectPage(page, queryWrapper);
        List<Branch> list = pages.getRecords();
        for (Branch branch : list) {

            if (ObjectUtils.isNotEmpty(branch.getPid())) {
                Project project = projectService.findProject(branch.getPid());
                branch.setProject(project);

            }
        }
        long total = pages.getTotal();
        pageResult.setTotal(total);
        pageResult.setRows(list);
        return pageResult;
    }

//    @Override
//    public PageResult findPage(QueryPageBean queryPageBean) {
//        PageResult pageResult = new PageResult();
//        Integer pageSize = queryPageBean.getPageSize();
//        int currentPage = queryPageBean.getCurrentPage();
//        String queryString = queryPageBean.getQueryString();
//        List<Branch> page = branchMapper.findBranchPage(currentPage -1 , pageSize ,queryString);
//        Long count = branchMapper.count();
//        pageResult.setRows(page);
//        pageResult.setTotal(count);
//        return pageResult;
//    }

    @Override
    public int addAndBind(Branch branch) {
//        branch.setBid(UUIDUtils.uuid());
        branch.setUpdateTime(new Date());
        int insert = branchMapper.insert(branch);

        return insert;

    }

    @Override
    public Result bindAndEdit(Branch branch) {
        branch.setUpdateTime(new Date());
        int row = branchMapper.updateById(branch);
//        int unBindCid = projectService.unBindCid(contractor.getCid());
//        int bindCid = projectService.bindCid(conProVo.getCid(), conProVo.getPids());
        if (row > 0 ) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @Override
    public Result deleteByBid(String bid) {
        int update = branchMapper.deleteByBid(bid);
        if (update > 0) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @Override
    public Result findByBid(String bid) {
        BranchDto branchDto = branchMapper.findBySidDto(bid);
        List<Project> list = projectService.findList();
        int[] pids = null;
        if (ObjectUtils.isNotEmpty(list)) {
            pids = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                pids[i] = list.get(i).getPid();
            }
        } else {
            pids = new int[0];
        }
        branchDto.setPids(pids);
        Result result = new Result();
        result.setMessage("fail");
        if (ObjectUtils.isNotEmpty(branchDto)) {
            result.setData(branchDto);
            result.setFlag(true);
            result.setMessage("success");
        }
        return result;
    }

    @Override
    public Branch findBranch(String bid) {
        QueryWrapper<Branch> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("bid", bid);
        queryWrapper.eq("status", 1);
        Branch branch = branchMapper.selectOne(queryWrapper);
        if (branch != null ){
            if (ObjectUtils.isNotEmpty(branch.getPid())) {
                Project project = projectService.findProject(branch.getPid());
                branch.setProject(project);
            }
        }
        return branch;
    }
}
