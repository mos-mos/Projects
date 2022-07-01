package com.construction.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.construction.model.Contractor;
import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;
import com.construction.page.Result;
import com.construction.vo.ConProVo;

public interface ContractService extends IService<Contractor> {
    PageResult findPage(QueryPageBean queryPageBean);

    int addAndBind(String cname,Integer[] pids);

    Result findByCid(String cid);


    Result deleteByDid(String cid);

    Result bindAndEdit(ConProVo conProVo);
}
