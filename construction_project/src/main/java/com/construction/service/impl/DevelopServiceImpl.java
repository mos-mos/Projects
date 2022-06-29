package com.construction.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.construction.dto.DeveloperDto;
import com.construction.mapper.DevelopMapper;
import com.construction.model.Developer;
import com.construction.model.Project;
import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;
import com.construction.page.Result;
import com.construction.service.DevelopService;
import com.construction.service.ProjectService;
import com.construction.utils.UUIDUtils;
import com.construction.vo.DevProVo;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DevelopServiceImpl extends ServiceImpl<DevelopMapper, Developer> implements DevelopService {

    @Autowired
    private DevelopMapper developMapper;
    @Autowired
    private ProjectService projectService;

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        PageResult pageResult = new PageResult();
        Integer pageSize = queryPageBean.getPageSize();
        Integer currentPage = queryPageBean.getCurrentPage();
        String queryString = queryPageBean.getQueryString();
        Page<Developer> page = new Page<>(currentPage, pageSize);
        QueryWrapper<Developer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status",1);
        if (ObjectUtils.isNotEmpty(queryString)) {
            queryWrapper.like("dName",queryString);
        }
        Page<Developer> pages = developMapper.selectPage(page, queryWrapper);
        List<Developer> list = pages.getRecords();
        long total = pages.getTotal();
        pageResult.setTotal(total);
        pageResult.setRows(list);
        return pageResult;
    }

    @Override
    @Transactional
    public int addAndBind(String dname,Integer[] pids) {
        Developer developer = new Developer();
        developer.setDid(UUIDUtils.uuid());
        developer.setDName(dname);
        developer.setUpdateTime(new Date());
        int insert = developMapper.insert(developer);
        int rom = 0;
        if (ObjectUtils.isNotEmpty(pids)) {
            rom = projectService.bindDid(developer.getDid(), pids);
        }
        if (insert > 0 && rom > 0) {
            return insert;
        }
        return 0;
    }

    @Override
    public Result findByDid(String did) {
        DeveloperDto developerDto = developMapper.findByDidDto(did);
        List<Project> list = projectService.findByDid(did);
        int[] pids = null;
        if (ObjectUtils.isNotEmpty(list)) {
            pids = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                pids[i] = list.get(i).getPid();
            }
            developerDto.setPids(pids);
        }else {
            pids = new int[0];
            developerDto.setPids(pids);
        }
        Result result = new Result();
        result.setMessage("fail");
        if (ObjectUtils.isNotEmpty(developerDto)) {
            result.setData(developerDto);
            result.setFlag(true);
            result.setMessage("success");
        }
        return result;
    }

    @Override
    @Transactional
    public Result bindAndEdit(DevProVo devProVo) {
        Developer developer = new Developer();
        developer.setDid(devProVo.getDid());
        developer.setDName(devProVo.getDName());
        developer.setUpdateTime(new Date());
        int row = developMapper.updateById(developer);
        int unBindDid = projectService.unBindDid(developer.getDid());
        int bindDid = projectService.bindDid(devProVo.getDid(), devProVo.getPids());
        if (row > 0 && unBindDid > 0 && bindDid > 00){
            return Result.success();
        }else {
            return Result.fail();
        }
    }



    @Override
    @Transactional
    public Result deleteByDid(String did) {
        int update = developMapper.deleteByDid(did,new Date());
        if (update > 0) {
            return Result.success();
        }else {
            return Result.fail();
        }
    }
}
