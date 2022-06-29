package com.construction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.construction.model.Developer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

@Mapper
public interface DevelopMapper extends BaseMapper<Developer> {
    @Select("select * from developer where did =#{did} and status=1")
    Developer findByDid(String did);

    @Update("UPDATE developer SET updatetime = #{updatetime} ,status = 0 where did = #{did}")
    int deleteByDid(@Param("did") String did ,@Param("updatetime") Date date);
}