package com.construction.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.construction.dto.StageDto;
import com.construction.mapper.StageMapper;
import com.construction.model.Project;
import com.construction.model.Stage;
import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;
import com.construction.page.Result;
import com.construction.service.ProjectService;
import com.construction.service.StageService;
import com.construction.utils.UUIDUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.construction.service.impl
 * @Author: mos
 * @CreateTime: 2022-06-30  09:51
 * @Description: StageServiceImpl
 * @Version: 1.0
 */
@Service
public class StageServiceImpl extends ServiceImpl<StageMapper, Stage> implements StageService {
    @Autowired
    private StageMapper stageMapper;
    @Autowired
    private ProjectService projectService;
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        PageResult pageResult = new PageResult();
        Integer pageSize = queryPageBean.getPageSize();
        Integer currentPage = queryPageBean.getCurrentPage();
        String queryString = queryPageBean.getQueryString();
        Page<Stage> page = new Page<>(currentPage, pageSize);
        QueryWrapper<Stage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1);
        if (ObjectUtils.isNotEmpty(queryString)) {
            queryWrapper.like("sName", queryString);
        }
        Page<Stage> pages = stageMapper.selectPage(page, queryWrapper);
        List<Stage> list = pages.getRecords();
        for (Stage stage : list) {
            if (ObjectUtils.isNotEmpty(stage.getPid())) {
                Project project = projectService.findProject(stage.getPid());
                stage.setProject(project);
            }
        }
        long total = pages.getTotal();
        pageResult.setTotal(total);
        pageResult.setRows(list);
        return pageResult;
    }

    @Override
    @Transactional
    public int addAndBind(Stage stage) {
//        Stage stage = new Stage();
        stage.setSid(UUIDUtils.uuid());
        stage.setUpdateTime(new Date());
        int insert = stageMapper.insert(stage);

            return insert;

    }
    @Override
    @Transactional
    public Result bindAndEdit(Stage stage) {
        stage.setUpdateTime(new Date());
        int row = stageMapper.updateById(stage);
//        int unBindCid = projectService.unBindCid(contractor.getCid());
//        int bindCid = projectService.bindCid(conProVo.getCid(), conProVo.getPids());
        if (row > 0 ) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @Override
    @Transactional
    public Result deleteBySid(String sid) {
        int update = stageMapper.deleteBySid(sid);
        if (update > 0) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @Override
    public Result findBySid(String sid) {
        StageDto stageDto = stageMapper.findBySidDto(sid);
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
        stageDto.setPids(pids);
        Result result = new Result();
        result.setMessage("fail");
        if (ObjectUtils.isNotEmpty(stageDto)) {
            result.setData(stageDto);
            result.setFlag(true);
            result.setMessage("success");
        }
        return result;
    }
}
