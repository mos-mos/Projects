package com.project.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.construction.ConstructionApplication;
import com.construction.mapper.DevelopMapper;
import com.construction.mapper.ProjectMapper;
import com.construction.model.Project;
import com.construction.service.DevelopService;
import com.construction.service.ProjectService;
import com.construction.vo.DevProVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest(classes = ConstructionApplication.class)
@RunWith(SpringRunner.class)
public class demo {
    @Autowired
    private DevelopService developService;
    @Test
    public void run() {
//        Integer currentPage = queryPageBean.getCurrentPage();
//        Integer pageSize = queryPageBean.getPageSize();
        Page<Project> page = new Page<>(0, 5);
//        QueryWrapper<Project> queryWrapper = new QueryWrapper<>();
//        queryWrapper.

//        Page<Project> lists = projectService.selectPage(page);

//        Page<Project> page1 = projectService.page(page);
    }
    @Test
    public void run1() {
    }
}
