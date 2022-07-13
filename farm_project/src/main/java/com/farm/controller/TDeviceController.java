package com.farm.controller;

import com.farm.constants.Status;
import com.farm.model.ProductBatches;
import com.farm.model.TDevice;
import com.farm.page.PageResult;
import com.farm.page.QueryPageBean;
import com.farm.page.Result;
import com.farm.service.TDeviceService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.farm.controller
 * @Author: mos
 * @CreateTime: 2022-07-13  10:09
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("device")
public class TDeviceController {
    @Autowired
    private TDeviceService tDeviceService;
    @PostMapping("allPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult result = tDeviceService.findPage(queryPageBean);
        return result;
    }
    @GetMapping("findById")
    public Result findById(int id){

        TDevice tDevice = tDeviceService.findById(id);
        Result result = new Result();
        result.setMessage("fail");
        if (ObjectUtils.isNotEmpty(tDevice)) {
            result.setFlag(Status.SUCCESS.isFlag());
            result.setData(tDevice);
            result.setMessage("success");
        }
        return result;
    }

    @PostMapping("add")
    public Result add(@RequestBody TDevice tDevice) {
        int row = tDeviceService.add(tDevice);
        if (row>0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }
    @PostMapping("update")
    public Result update(@RequestBody TDevice tDevice) {
        int row = tDeviceService.edit(tDevice);
        if (row > 0) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(int id) {
        int result =  tDeviceService.deleteById(id);
        if (result>0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }

}
