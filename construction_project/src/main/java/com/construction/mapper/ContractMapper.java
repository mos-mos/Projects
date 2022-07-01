package com.construction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.construction.dto.ContractorDto;
import com.construction.model.Contractor;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.Date;

@Mapper
public interface ContractMapper extends BaseMapper<Contractor> {

    @Results(id = "conMap",value = {
            @Result(column = "cid",property = "cid"),
            @Result(column = "cname",property = "cName"),
            @Result(column = "updatetime",property = "updateTime"),
            @Result(column = "cid",property = "projects",many =   //一对多映射
                    //select 关联查询
            @Many(select ="com.construction.mapper.ProjectMapper.findByCid" ,fetchType = FetchType.EAGER)
            )
    })
    @Select("select * from contractor where cid =#{cid} and status =1")
    Contractor findConByCid(String cid);
    @Select("select * from contractor where cid =#{cid} and status=1")
    ContractorDto findByCidDto(String cid);


    @Update("UPDATE contractor SET updatetime = #{updatetime} ,status = 0 where cid = #{cid}")
    int deleteByCid(@Param("cid") String cid , @Param("updatetime") Date date);

}
