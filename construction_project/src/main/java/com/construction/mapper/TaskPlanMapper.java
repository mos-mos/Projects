package com.construction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.construction.model.TaskPlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

// 任务计划表 Mapper
@Mapper
public interface TaskPlanMapper extends BaseMapper<TaskPlan> {
    @Update("UPDATE taskplan SET updatetime = now(),status = 0 where bid = #{bid} ")
    int deleteByTid(String tid);
}
