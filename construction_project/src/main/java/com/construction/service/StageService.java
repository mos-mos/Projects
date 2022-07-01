package com.construction.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.construction.model.Stage;
import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;
import com.construction.page.Result;

public interface StageService extends IService<Stage> {
    PageResult findPage(QueryPageBean queryPageBean);

    int addAndBind(Stage stage);

    Result bindAndEdit(Stage stage);

    Result deleteBySid(String sid);

    Result findBySid(String sid);
}
