package com.farm.service.impl;

import com.farm.mapper.TDeviceGatherMapper;
import com.farm.model.TDeviceGather;
import com.farm.page.PageResult;
import com.farm.page.QueryPageBean;
import com.farm.service.TDeviceGatherService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.farm.service.impl
 * @Author: mos
 * @CreateTime: 2022-07-13  10:33
 * @Description: 设备采集表 service
 * @Version: 1.0
 */
@Service
public class TDeviceGatherServiceImpl implements TDeviceGatherService {
    @Autowired
    private TDeviceGatherMapper tDeviceGatherMapper;
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        Page<TDeviceGather> pages = tDeviceGatherMapper.selectTDeviceGatherPage(queryPageBean.getQueryString());
        PageResult result = new PageResult();
        result.setRows(pages.getResult());
        result.setTotal(pages.getTotal());
        return result;
    }

    @Override
    public TDeviceGather findById(int id) {
        TDeviceGather result = tDeviceGatherMapper.selectTDeviceGatherById((long) id);
        return result;
    }

    @Override
    @Transactional
    public int add(TDeviceGather tDeviceGather) {
        tDeviceGather.setCreateTime(new Date());
        tDeviceGather.setUpdateTime(new Date());
        int result = tDeviceGatherMapper.insertTDeviceGather(tDeviceGather);
        return result;
    }

    @Override
    @Transactional
    public int edit(TDeviceGather tDeviceGather) {
        tDeviceGather.setUpdateTime(new Date());
        int result = tDeviceGatherMapper.updateTDeviceGather(tDeviceGather);
        return result;
    }

    @Override
    @Transactional
    public int deleteById(int id) {
        int result = tDeviceGatherMapper.deleteTDeviceGatherById(id);
        return result;
    }

}
