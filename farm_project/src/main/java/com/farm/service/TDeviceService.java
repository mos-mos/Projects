package com.farm.service;

import com.farm.model.TDevice;
import com.farm.page.PageResult;
import com.farm.page.QueryPageBean;

public interface TDeviceService {
    PageResult findPage(QueryPageBean queryPageBean);

    TDevice findById(int id);

    int add(TDevice tDevice);

    int edit(TDevice tDevice);

    int deleteById(int id);
}
