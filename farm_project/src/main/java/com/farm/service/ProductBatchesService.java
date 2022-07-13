package com.farm.service;

import com.farm.model.ProductBatches;
import com.farm.page.PageResult;
import com.farm.page.QueryPageBean;

public interface ProductBatchesService {
    /**
     * @description: 查询翻页
     * @author: mos / Wang Zero
     * @param: queryPageBean
     * @return: com.farm.page.PageResult
     * @Date: 2022/7/12 14:45
     * @Version 1.0.0
     */

    PageResult findPage(QueryPageBean queryPageBean);

    ProductBatches findById(int id);

    int add(ProductBatches productBatches);

    int edit(ProductBatches productBatches);

    int deleteById(int id);
}
