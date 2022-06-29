package com.construction.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.construction.model.Developer;
import com.construction.model.Project;
import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;
import com.construction.page.Result;
import com.construction.service.DevelopService;
import com.construction.vo.DevProVo;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.construction.controller
 * @Author: mos
 * @CreateTime: 2022-06-28  17:55
 * @Description: 开发商Controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("developer")
public class DevelopController {
    @Autowired
    private DevelopService developService;

    @PostMapping("allPage")
    public PageResult page(@RequestBody QueryPageBean queryPageBean) {
        PageResult result = developService.findPage(queryPageBean);
        return result;
    }

    @PostMapping("add")
    public Result add(String dname,Integer[] pids) {
        System.out.println(dname);
        System.out.println(Arrays.toString(pids));
        int rom = developService.addAndBind(dname, pids);
        if(rom > 0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }

    @GetMapping("findByDid")
    public Result findByPid(@RequestParam("did") String did){
        Result result = developService.findByDid(did);
        return result;
    }

    @PostMapping("edit")
    public Result edit(@RequestBody Developer developer){
        developer.setUdpateTime(new Date());
        boolean update = developService.updateById(developer);
        if (update) {
            return Result.success();
        }else {
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(@RequestParam("did") String did){
        Result result = developService.deleteByDid(did);
        return result;
    }
}
