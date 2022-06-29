package com.construction.controller;




import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.construction.page.PageResult;
import com.construction.model.Project;
import com.construction.page.QueryPageBean;
import com.construction.page.Result;
import com.construction.service.ProjectService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Wang Zero
 */
@RestController
@RequestMapping("project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("findByPid")
    public Result findByPid(@RequestParam("pid") Integer pid){
        System.out.println(pid);
        Project project = projectService.getById(pid);
        Result result = new Result();
        result.setMessage("fail");
        if (ObjectUtils.isNotEmpty(project)) {
            result.setData(project);
            result.setFlag(true);
            result.setMessage("success");
        }
        return result;
    }

    /**
     * @description: 查找所有工程
     * @author: mos / Wang Zero
     * @return: java.util.List<com.construction.model.Project>
     * @Date: 2022/6/28 22:53
     * @Version 1.0.0
     */

    @GetMapping("findAll")
    public List<Project> findAll(){
        QueryWrapper<Project> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status",1);
        List<Project> list = projectService.list(queryWrapper);
        return list;
    }

//    @PostMapping("all")
//    public PageResult all(@RequestBody QueryPageBean queryPageBean){
//
//        PageResult result =  projectService.findPage(queryPageBean);
//        return result;
//    }

    @PostMapping("allPage")
    public PageResult all(@RequestBody QueryPageBean queryPageBean) {
        PageResult result = new PageResult();
        Page<Project> pages = projectService.findPage(queryPageBean);
        long total = pages.getTotal();
        List<Project> list = pages.getRecords();
        result.setTotal(total);
        result.setRows(list);

//        PageResult page = projectService.findPageById(queryPageBean);
        return result;
    }


    /**
     * @description: 添加项目
     * @author: mos Wang Zero 
     * @param: project 
     * @return: com.construction.page.Result
     * @Date: 2022/6/28 15:06
     * @Version 1.0.0
     */
    
    @PostMapping("add")
    public Result addProject(@RequestBody Project project){
        int row = projectService.addProject(project);
        if(row > 0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }

    @PostMapping("edit")
    public Result editProject(@RequestBody Project project) {
        int row = projectService.editProject(project);
        if(row > 0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result deleteProject(@RequestParam("pid") Integer pid) {
        int row = projectService.deleteProject(pid);
        if(row > 0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }


}
