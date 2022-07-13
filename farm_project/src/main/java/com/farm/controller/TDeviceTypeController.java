package com.farm.controller;

import com.farm.model.TDeviceType;
import com.farm.model.TFarm;
import com.farm.page.PageResult;
import com.farm.page.QueryPageBean;
import com.farm.page.Result;
import com.farm.service.TDeviceTypeService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.farm.controller
 * @Author: mos
 * @CreateTime: 2022-07-13  10:40
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("type")
public class TDeviceTypeController {
    @Autowired
    private TDeviceTypeService tDeviceTypeService;

    @GetMapping("findTypeAll")
    public List<TDeviceType> findAll() {
        List<TDeviceType> lists = tDeviceTypeService.findAll();
        return lists;
    }

    @GetMapping("findById")
    public Result findById(int id) {
//        System.out.println(id);
        TDeviceType  deviceType = tDeviceTypeService.findById(id);
        Result result = new Result();
        result.setMessage("fail");
        if (ObjectUtils.isNotEmpty(deviceType)) {
            result.setFlag(true);
            result.setData(deviceType);
            result.setMessage("success");
        }
        return result;
    }
    @PostMapping("allPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult result = tDeviceTypeService.findPage(queryPageBean);
        return result;
    }
    @PostMapping("add")
    public Result add(@RequestBody TDeviceType deviceType) {
        int row = tDeviceTypeService.add(deviceType);
        if (row>0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }
    @PostMapping("update")
    public Result update(@RequestBody TDeviceType  deviceType) {
        int row = tDeviceTypeService.edit(deviceType);
        if (row > 0) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(int id) {
        int result =  tDeviceTypeService.deleteById(id);
        if (result>0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }

}
