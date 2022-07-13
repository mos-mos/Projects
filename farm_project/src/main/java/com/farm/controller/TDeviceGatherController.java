package com.farm.controller;

import com.farm.mapper.TDeviceGatherMapper;
import com.farm.model.TDeviceGather;
import com.farm.model.TDeviceGather;
import com.farm.page.PageResult;
import com.farm.page.QueryPageBean;
import com.farm.page.Result;
import com.farm.service.TDeviceGatherService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.farm.controller
 * @Author: mos
 * @CreateTime: 2022-07-13  10:33
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("gather")
public class TDeviceGatherController {

    @Autowired
    private TDeviceGatherService tDeviceGatherService;
    @PostMapping("allPage")
    public PageResult addUser(@RequestBody QueryPageBean queryPageBean) {
        PageResult result = tDeviceGatherService.findPage(queryPageBean);
        return result;
    }



    @GetMapping("findById")
    public Result findById(int id) {
//        System.out.println(id);
        TDeviceGather tDeviceGather = tDeviceGatherService.findById(id);
        Result result = new Result();
        result.setMessage("fail");
        if (ObjectUtils.isNotEmpty(tDeviceGather)) {
            result.setFlag(true);
            result.setData(tDeviceGather);
            result.setMessage("success");
        }
        return result;
    }

    @PostMapping("add")
    public Result add(@RequestBody TDeviceGather tDeviceGather) {
        int count = tDeviceGatherService.add(tDeviceGather);
        if (count>0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result edit(@RequestBody TDeviceGather tDeviceGather) {
        tDeviceGather.setUpdateTime(new Date());
        int row = tDeviceGatherService.edit(tDeviceGather);

        if (row > 0) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(int id) {
        int result =  tDeviceGatherService.deleteById(id);
        if (result>0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }
}
