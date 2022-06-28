package com.construction.controller;

import com.construction.page.PageResult;
import com.construction.model.Project;
import com.construction.page.QueryPageBean;
import com.construction.page.Result;
import com.construction.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    /**
     * 查找所有
     * @return 查找到的所有列表
     */
    @GetMapping("findAll")
    public List<Project> findAll(){
        List<Project> list = projectService.list();
        return list;
    }

//    @PostMapping("all")
//    public PageResult all(@RequestBody QueryPageBean queryPageBean){
//
//        PageResult result =  projectService.findPage(queryPageBean);
//        return result;
//    }

    @PostMapping("all")
    public PageResult all(@RequestBody QueryPageBean queryPageBean) {
        PageResult page = projectService.findPage(queryPageBean);
//        PageResult page = projectService.findPageById(queryPageBean);

        return page;
    }

    @PostMapping("add")
    public Result addProject(@RequestBody Project project){
        int row = projectService.addProject(project);
        Result result = new Result();
        if(row > 0){
            result.setMessage("success");
            result.setFlag(true);
        }else {
            result.setMessage("fail");
        }
        return result;

    }
}
