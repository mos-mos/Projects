package com.farm.controller;

import com.farm.constants.Status;
import com.farm.model.ProductBatches;
import com.farm.page.PageResult;
import com.farm.page.QueryPageBean;
import com.farm.page.Result;
import com.farm.service.ProductBatchesService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.farm.controller
 * @Author: mos
 * @CreateTime: 2022-07-12  11:53
 * @Description: 农产品批次 控制器
 * @Version: 1.0
 */
@RestController
@RequestMapping("product")
public class ProductBatchesController {
    @Autowired
    private ProductBatchesService productBatchesService;
    @PostMapping("allPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult result = productBatchesService.findPage(queryPageBean);
        return result;
    }
    @GetMapping("findById")
    public Result findById(int id){
        ProductBatches productBatches = productBatchesService.findById(id);
        Result result = new Result();
        result.setMessage("fail");
        if (ObjectUtils.isNotEmpty(productBatches)) {
            result.setFlag(Status.SUCCESS.isFlag());
            result.setData(productBatches);
            result.setMessage("success");
        }
        return result;
    }

    @PostMapping("add")
    public Result add(@RequestBody ProductBatches productBatches) {
        int row = productBatchesService.add(productBatches);
        if (row>0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }
    @PostMapping("update")
    public Result update(@RequestBody ProductBatches productBatches) {
        int row = productBatchesService.edit(productBatches);
        if (row > 0) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(int id) {
        int result =  productBatchesService.deleteById(id);
        if (result>0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }

}
