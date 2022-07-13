package com.construction.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.construction.model.Branch;
import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;
import com.construction.page.Result;

public interface BranchService extends IService<Branch>{
    PageResult findPage(QueryPageBean queryPageBean);

    int addAndBind(Branch branch);

    Result bindAndEdit(Branch branch);

    Result deleteByBid(String bid);

    Result findByBid(String bid);

    Branch findBranch(String bid);

}
