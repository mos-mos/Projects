package com.project.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.construction.model.Project;
import com.construction.service.ProjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class demo {
    @Autowired
    private ProjectService projectService;
    @Test
    public void run() {
//        Integer currentPage = queryPageBean.getCurrentPage();
//        Integer pageSize = queryPageBean.getPageSize();
        Page<Project> page = new Page<>(0, 5);
//        QueryWrapper<Project> queryWrapper = new QueryWrapper<>();
//        queryWrapper.

        Page<Project> lists = projectService.selectPage(page);

//        Page<Project> page1 = projectService.page(page);
    }
}
