package com.construction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.construction.dto.StageDto;
import com.construction.model.Stage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StageMapper extends BaseMapper<Stage> {
    @Update("UPDATE stage SET updatetime = now(),status = 0 where sid = #{sid}")
    int deleteBySid(@Param("sid") String sid );

    @Select("select * from stage where sid =#{sid} and status= 1")
    StageDto findBySidDto(String sid);
}
