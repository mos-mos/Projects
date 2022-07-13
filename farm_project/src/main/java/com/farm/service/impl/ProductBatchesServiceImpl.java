package com.farm.service.impl;

import com.farm.mapper.ProductBatchesMapper;
import com.farm.model.ProductBatches;
import com.farm.page.PageResult;
import com.farm.page.QueryPageBean;
import com.farm.service.ProductBatchesService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.farm.service.impl
 * @Author: mos
 * @CreateTime: 2022-07-12  14:11
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class ProductBatchesServiceImpl implements ProductBatchesService {
    @Autowired
    private ProductBatchesMapper productBatchesMapper;

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        Page<ProductBatches> pageList =  productBatchesMapper.selectProductBatchesPage(queryPageBean.getQueryString());
        pageList.stream().forEach(page ->
                page.setIsActive(page.getIsActive().equalsIgnoreCase("y")?"启用":"关闭"));
        PageResult result = new PageResult();
        result.setRows(pageList.getResult());
        result.setTotal(pageList.getTotal());
        return result;
    }

    @Override
    public ProductBatches findById(int id) {
        ProductBatches productBatches = productBatchesMapper.selectProductBatchesById((long)id);
        return productBatches;
    }

    @Override
    @Transactional
    public int add(ProductBatches productBatches) {
        int result = productBatchesMapper.insertProductBatches(productBatches);
        return result;
    }

    @Override
    @Transactional
    public int edit(ProductBatches productBatches) {
        int result = productBatchesMapper.updateProductBatches(productBatches);
        return result;
    }

    @Override
    @Transactional
    public int deleteById(int id) {
        int result = productBatchesMapper.deleteProductBatchesById((long)id);
        return result;
    }
}
