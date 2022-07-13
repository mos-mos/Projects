package com.farm.service;

import com.farm.model.TFarm;
import com.farm.page.PageResult;
import com.farm.page.QueryPageBean;

import java.util.List;

public interface FarmService {
    PageResult findPage(QueryPageBean queryPageBean);

    int addFarm(TFarm farm);

    int edit(TFarm farm);

    int deleteById(int id);

    TFarm findById(int id);

    List<TFarm> findAll();

}
