package com.construction.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.construction.dto.ContractorDto;
import com.construction.mapper.ContractMapper;
import com.construction.model.Contractor;
import com.construction.model.Project;
import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;
import com.construction.page.Result;
import com.construction.service.ContractService;
import com.construction.service.ProjectService;
import com.construction.utils.UUIDUtils;
import com.construction.vo.ConProVo;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contractor> implements ContractService {

    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private ProjectService projectService;

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        PageResult pageResult = new PageResult();
        Integer pageSize = queryPageBean.getPageSize();
        Integer currentPage = queryPageBean.getCurrentPage();
        String queryString = queryPageBean.getQueryString();
        Page<Contractor> page = new Page<>(currentPage, pageSize);
        QueryWrapper<Contractor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1);
        if (ObjectUtils.isNotEmpty(queryString)) {
            queryWrapper.like("cName", queryString);
        }
        Page<Contractor> pages = contractMapper.selectPage(page, queryWrapper);
        List<Contractor> list = pages.getRecords();
        long total = pages.getTotal();
        pageResult.setTotal(total);
        pageResult.setRows(list);
        return pageResult;
    }

    @Override
    @Transactional
    public int addAndBind(String cname, Integer[] pids) {
        Contractor contractor = new Contractor();
        contractor.setCid(UUIDUtils.uuid());
        contractor.setCName(cname);
        contractor.setUpdateTime(new Date());
        int insert = contractMapper.insert(contractor);
        int rom = 0;
        if (ObjectUtils.isNotEmpty(pids)) {
            rom = projectService.bindCid(contractor.getCid(), pids);
        }
        if (insert > 0 && rom > 0) {
            return insert;
        }
        return 0;
    }

    @Override
    public Result findByCid(String cid) {
        ContractorDto contractorDto = contractMapper.findByCidDto(cid);
        List<Project> list = projectService.findByCid(cid);
        int[] pids = null;
        if (ObjectUtils.isNotEmpty(list)) {
            pids = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                pids[i] = list.get(i).getPid();
            }
        } else {
            pids = new int[0];
        }
        contractorDto.setPids(pids);
        Result result = new Result();
        result.setMessage("fail");
        if (ObjectUtils.isNotEmpty(contractorDto)) {
            result.setData(contractorDto);
            result.setFlag(true);
            result.setMessage("success");
        }
        return result;
    }

    @Override
    @Transactional
    public Result bindAndEdit(ConProVo conProVo) {
        Contractor contractor = new Contractor();
        contractor.setCid(conProVo.getCid());
        contractor.setCName(conProVo.getCName());
        contractor.setUpdateTime(new Date());
        int row = contractMapper.updateById(contractor);
        int unBindCid = projectService.unBindCid(contractor.getCid());
        int bindCid = projectService.bindCid(conProVo.getCid(), conProVo.getPids());
        if (row > 0 && unBindCid > 0 && bindCid > 00) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }


    @Override
    @Transactional
    public Result deleteByDid(String cid) {
        int update = contractMapper.deleteByCid(cid, new Date());
        if (update > 0) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }
}
