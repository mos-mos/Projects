package com.construction.controller;

import com.construction.page.PageResult;
import com.construction.page.QueryPageBean;
import com.construction.page.Result;
import com.construction.service.ContractService;
import com.construction.vo.ConProVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.construction.controller
 * @Author: mos
 * @CreateTime: 2022-06-28  17:55
 * @Description: 承建商Controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @PostMapping("allPage")
    public PageResult page(@RequestBody QueryPageBean queryPageBean) {
        PageResult result = contractService.findPage(queryPageBean);
        return result;
    }

    @PostMapping("add")
    public Result add(String cname,Integer[] pids) {
        System.out.println(cname);
        System.out.println(Arrays.toString(pids));
        int rom = contractService.addAndBind(cname, pids);
        if(rom > 0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }

    @GetMapping("findByCid")
    public Result findByPid(@RequestParam("cid") String cid){
        Result result = contractService.findByCid(cid);
        return result;
    }

    @PostMapping("edit")
    public Result edit(@RequestBody ConProVo conProVo){
        Result result = contractService.bindAndEdit(conProVo);
        return result;

    }

    @GetMapping("delete")
    public Result delete(@RequestParam("cid") String cid){
        Result result = contractService.deleteByDid(cid);
        return result;
    }
}
