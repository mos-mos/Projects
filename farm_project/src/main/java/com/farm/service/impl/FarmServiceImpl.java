package com.farm.service.impl;

import com.farm.mapper.FarmMapper;
import com.farm.model.SysUser;
import com.farm.model.TFarm;
import com.farm.page.PageResult;
import com.farm.page.QueryPageBean;
import com.farm.page.Result;
import com.farm.service.FarmService;
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
 * @CreateTime: 2022-07-09  09:20
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class FarmServiceImpl implements FarmService {
    @Autowired
    private FarmMapper farmMapper;

    @Override
    public List<TFarm> findAll() {
        List<TFarm> farmList = farmMapper.selectTFarmAll();
        return farmList;
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        Page<TFarm> tFarms = farmMapper.selectTFarmPage(queryPageBean.getQueryString());
        PageResult result = new PageResult();
        result.setRows(tFarms.getResult());
        result.setTotal(tFarms.getTotal());
        return result;
    }

    @Override
    public TFarm findById(int id) {
        TFarm result = farmMapper.selectTFarmById((long) id);
        return result;
    }

    @Override
    @Transactional
    public int addFarm(TFarm farm) {
        farm.setCreateTime(new Date());
        farm.setUpdateTime(new Date());
        int result = farmMapper.insertTFarm(farm);
        return result;
    }

    @Override
    @Transactional
    public int edit(TFarm farm) {
        farm.setUpdateTime(new Date());
        int result = farmMapper.updateTFarm(farm);
        return result;
    }

    @Override
    @Transactional
    public int deleteById(int id) {
        int result = farmMapper.deleteTFarmById(id);
        return result;
    }
}
