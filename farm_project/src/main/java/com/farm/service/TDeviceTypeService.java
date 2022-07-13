package com.farm.service;

import com.farm.model.TDeviceType;
import com.farm.model.TFarm;
import com.farm.page.PageResult;
import com.farm.page.QueryPageBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TDeviceTypeService {
    PageResult findPage(QueryPageBean queryPageBean);

    @Transactional
    int add(TDeviceType deviceType);

    @Transactional
    int edit(TDeviceType tDeviceType);

    @Transactional
    int deleteById(int id);

    TDeviceType findById(int id);

    List<TDeviceType> findAll();
}
