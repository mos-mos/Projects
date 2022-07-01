package com.construction.controller;

import com.construction.model.Branch;
import com.construction.model.Stage;
import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;
import com.construction.page.Result;
import com.construction.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.construction.controller
 * @Author: mos
 * @CreateTime: 2022-06-30  15:11
 * @Description: 开发商部门Controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("branch")
public class BranchController {
    @Autowired
    private BranchService branchService;
    @PostMapping("allPage")
    public PageResult page(@RequestBody QueryPageBean queryPageBean) {
        PageResult result = branchService.findPage(queryPageBean);

        return result;
    }
    @PostMapping("add")
    public Result add(@RequestBody Branch branch) {
        System.out.println(branch.getBName());
        System.out.println(branch.getPid());
        int rom = branchService.addAndBind(branch);
        if(rom > 0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }
    @PostMapping("edit")
    public Result edit(@RequestBody Branch branch ){
        Result result = branchService.bindAndEdit(branch);
        return result;
    }

    @GetMapping("delete")
    public Result delete(@RequestParam("bid") String bid){
        Result result = branchService.deleteByBid(bid);
        return result;
    }

    @GetMapping("findByBid")
    public Result findBySid(@RequestParam("bid") String bid){
        Result result = branchService.findByBid(bid);
        return result;
    }

}
