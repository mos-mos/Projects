package com.construction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.construction.dto.ContractorDto;
import com.construction.dto.DeveloperDto;
import com.construction.model.Contractor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

@Mapper
public interface ContractMapper extends BaseMapper<Contractor> {
    @Select("select * from contractor where cid =#{cid} and status=1")
    ContractorDto findByCidDto(String cid);


    @Update("UPDATE contractor SET updatetime = #{updatetime} ,status = 0 where cid = #{cid}")
    int deleteByCid(@Param("cid") String did , @Param("updatetime") Date date);

}
