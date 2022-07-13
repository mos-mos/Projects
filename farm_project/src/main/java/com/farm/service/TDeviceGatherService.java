package com.farm.service;

import com.farm.model.TDeviceGather;
import com.farm.page.PageResult;
import com.farm.page.QueryPageBean;

public interface TDeviceGatherService {
    PageResult findPage(QueryPageBean queryPageBean);

    TDeviceGather findById(int id);

    int add(TDeviceGather tDeviceGather);

    int edit(TDeviceGather tDeviceGather);

    int deleteById(int id);
}
