package com.farm.controller;

import com.farm.model.SysUser;
import com.farm.model.TFarm;
import com.farm.page.PageResult;
import com.farm.page.QueryPageBean;
import com.farm.page.Result;
import com.farm.service.FarmService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.farm.controller
 * @Author: mos
 * @CreateTime: 2022-07-09  09:17
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("farm")
public class FarmController {
    @Autowired
    private FarmService farmService;

    @GetMapping("findFarmAll")
    public List<TFarm> findAll() {
       List<TFarm> farmList = farmService.findAll();
       return farmList;
    }

    @GetMapping("findById")
    public Result findById(int id) {
//        System.out.println(id);
        TFarm farm = farmService.findById(id);
        Result result = new Result();
        result.setMessage("fail");
        if (ObjectUtils.isNotEmpty(farm)) {
            result.setFlag(true);
            result.setData(farm);
            result.setMessage("success");
        }
        return result;
    }
    @PostMapping("allPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult result = farmService.findPage(queryPageBean);
        return result;
    }
    @PostMapping("add")
    public Result add(@RequestBody TFarm farm) {
        int row = farmService.addFarm(farm);
        if (row>0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }
    @PostMapping("update")
    public Result update(@RequestBody TFarm farm) {
        int row = farmService.edit(farm);
        if (row > 0) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(int id) {
        int result =  farmService.deleteById(id);
        if (result>0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }
}
