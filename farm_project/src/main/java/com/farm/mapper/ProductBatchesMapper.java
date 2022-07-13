package com.farm.mapper;

import com.farm.model.ProductBatches;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductBatchesMapper {
    Page<ProductBatches> selectProductBatchesPage(String queryString);
    ProductBatches selectProductBatchesById(long id);

    int insertProductBatches(ProductBatches productBatches);

    int updateProductBatches(ProductBatches productBatches);

    int deleteProductBatchesById(long id);
}
