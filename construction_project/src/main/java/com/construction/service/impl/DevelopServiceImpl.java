package com.construction.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.construction.mapper.DevelopMapper;
import com.construction.mapper.ProjectMapper;
import com.construction.model.Developer;
import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;
import com.construction.page.Result;
import com.construction.service.DevelopService;
import com.construction.service.ProjectService;
import com.construction.utils.UUIDUtils;
import com.construction.vo.DevProVo;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
        developer.setUdpateTime(new Date());
        int insert = developMapper.insert(developer);
        int rom = projectService.bandDid(developer.getDid(), pids);
        if (insert > 0 && rom > 0 ) {
            return insert;
        }
        return 0;
    }

    @Override
    public Result findByDid(String did) {
        QueryWrapper<Developer> qw = new QueryWrapper<>();
        qw.eq("did",did);
        qw.eq("status",1);
        Developer developer = developMapper.selectOne(qw);
        Result result = new Result();
        result.setMessage("fail");
        if (ObjectUtils.isNotEmpty(developer)) {
            result.setData(developer);
            result.setFlag(true);
            result.setMessage("success");
        }
        return result;
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
