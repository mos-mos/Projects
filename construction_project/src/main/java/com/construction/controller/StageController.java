package com.construction.controller;

import com.construction.model.Stage;
import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;
import com.construction.page.Result;
import com.construction.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.construction.controller
 * @Author: mos
 * @CreateTime: 2022-06-30  09:52
 * @Description: 工程阶段Controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("stage")
public class StageController {
    @Autowired
    private StageService stageService;
    @PostMapping("allPage")
    public PageResult page(@RequestBody QueryPageBean queryPageBean) {
        PageResult result = stageService.findPage(queryPageBean);
        return result;
    }
    @PostMapping("add")
    public Result add(@RequestBody Stage stage) {
        System.out.println(stage.getSName());
        System.out.println(stage.getPid());
        int rom = stageService.addAndBind(stage);
        if(rom > 0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }
    @PostMapping("edit")
    public Result edit(@RequestBody Stage stage ){
        Result result = stageService.bindAndEdit(stage);
        return result;
    }

    @GetMapping("delete")
    public Result delete(@RequestParam("sid") String sid){
        Result result = stageService.deleteBySid(sid);
        return result;
    }

    @GetMapping("findBySid")
    public Result findBySid(@RequestParam("sid") String sid){
        Result result = stageService.findBySid(sid);
        return result;
    }
}
