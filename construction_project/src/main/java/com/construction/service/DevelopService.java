package com.construction.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.construction.dto.DeveloperDto;
import com.construction.model.Developer;
import com.construction.model.Project;
import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;
import com.construction.page.Result;
import com.construction.vo.DevProVo;

import java.util.List;

public interface DevelopService extends IService<Developer> {
    PageResult findPage(QueryPageBean queryPageBean);

    int addAndBind(String dname,Integer[] pids);

    Result findByDid(String did);


    Result deleteByDid(String did);

    Result bindAndEdit(DevProVo devProVo);
}
