package com.farm.service.impl;

import com.farm.mapper.TDeviceMapper;
import com.farm.model.TDevice;
import com.farm.page.PageResult;
import com.farm.page.QueryPageBean;
import com.farm.service.TDeviceService;
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
 * @CreateTime: 2022-07-13  10:12
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class TDeviceServiceImpl implements TDeviceService {
    @Autowired
    private TDeviceMapper tDeviceMapper;
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        Page<TDevice> pageList =  tDeviceMapper.selectTDevicePage(queryPageBean.getQueryString());
        pageList.stream().forEach(page ->
                page.setState(page.getState().equals("0")?"在线":"离线"));
        PageResult result = new PageResult();
        result.setRows(pageList.getResult());
        result.setTotal(pageList.getTotal());
        return result;
    }

    @Override
    public TDevice findById(int id) {
        TDevice tDevice = tDeviceMapper.selectTDeviceById((long)id);
        return tDevice;
    }

    @Override
    @Transactional
    public int add(TDevice tDevice) {
        tDevice.setCreateTime(new Date());
        tDevice.setUpdateTime(new Date());
        int result = tDeviceMapper.insertTDevice(tDevice);
        return result;
    }

    @Override
    @Transactional
    public int edit(TDevice tDevice) {
        tDevice.setUpdateTime(new Date());
        int result = tDeviceMapper.updateTDevice(tDevice);
        return result;
    }

    @Override
    @Transactional
    public int deleteById(int id) {
        int result = tDeviceMapper.deleteTDeviceById((long)id);
        return result;
    }
}
