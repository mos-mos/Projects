package com.construction.controller;

import com.construction.model.TaskPlan;
import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;
import com.construction.page.Result;
import com.construction.service.TaskPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.construction.controller
 * @Author: mos
 * @CreateTime: 2022-07-06  08:27
 * @Description: 计划任务 controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("taskplan")
public class TaskPlanController {
    @Autowired
    private TaskPlanService taskService;

    @PostMapping("allPage")
    public PageResult page(@RequestBody QueryPageBean queryPageBean) {
        PageResult result = taskService.findPage(queryPageBean);
        return result;
    }


    @PostMapping("add")
    public Result add(@RequestBody TaskPlan taskPlan) {
        System.out.println(taskPlan.getTName());
        System.out.println(taskPlan.getTid());
        int rom = taskService.addAndBind(taskPlan);
        if(rom > 0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }
    @PostMapping("edit")
    public Result edit(@RequestBody TaskPlan taskPlan ){
        Result result = taskService.bindAndEdit(taskPlan);
        return result;
    }

    @GetMapping("delete")
    public Result delete(@RequestParam("tid") String tid){
        Result result = taskService.deleteByTid(tid);
        return result;
    }

    @GetMapping("findByBid")
    public Result findBySid(@RequestParam("tid") String tid){
        Result result = taskService.findByTid(tid);
        return result;
    }

}
