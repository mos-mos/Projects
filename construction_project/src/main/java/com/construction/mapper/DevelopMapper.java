package com.construction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.construction.model.Developer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DevelopMapper extends BaseMapper<Developer> {
    @Select("select * from developer where did =#{did} and status=1")
    Developer findByDid(String did);
}