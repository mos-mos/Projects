package com.farm.service.impl;

import com.farm.mapper.TDeviceTypeMapper;
import com.farm.model.TDeviceType;
import com.farm.model.TFarm;
import com.farm.page.PageResult;
import com.farm.page.QueryPageBean;
import com.farm.service.TDeviceTypeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.farm.service.impl
 * @Author: mos
 * @CreateTime: 2022-07-13  10:38
 * @Description: 设备类型 service
 * @Version: 1.0
 */
@Service
public class TDeviceTypeServiceImpl implements TDeviceTypeService {
    @Autowired
    private TDeviceTypeMapper tDeviceTypeMapper;

    @Override
    public List<TDeviceType> findAll() {
        List<TDeviceType> lists = tDeviceTypeMapper.selectTDeviceTypeAll();
        return lists;
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        Page<TDeviceType> tDeviceTypes = tDeviceTypeMapper.selectTDeviceTypePage(queryPageBean.getQueryString());
        PageResult result = new PageResult();
        result.setRows(tDeviceTypes.getResult());
        result.setTotal(tDeviceTypes.getTotal());
        return result;
    }

    @Override
    public TDeviceType findById(int id) {
        TDeviceType result = tDeviceTypeMapper.selectTDeviceTypeById((long) id);
        return result;
    }

    @Override
    @Transactional
    public int add(TDeviceType tDeviceType) {
        tDeviceType.setCreateTime(new Date());
        tDeviceType.setUpdateTime(new Date());
        int result = tDeviceTypeMapper.insertTDeviceType(tDeviceType);
        return result;
    }

    @Override
    @Transactional
    public int edit(TDeviceType tDeviceType) {
        tDeviceType.setUpdateTime(new Date());
        int result = tDeviceTypeMapper.updateTDeviceType(tDeviceType);
        return result;
    }

    @Override
    @Transactional
    public int deleteById(int id) {
        int result = tDeviceTypeMapper.deleteTDeviceTypeById((long)id);
        return result;
    }
}
