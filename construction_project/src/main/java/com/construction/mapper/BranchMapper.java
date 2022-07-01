package com.construction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.construction.dto.BranchDto;
import com.construction.model.Branch;
import com.construction.model.Project;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface BranchMapper extends BaseMapper<Branch> {

    @Results(id = "branchMap", value = {
            @Result(column = "bid", property = "bid"),
            @Result(column = "bname", property = "bName"),
            @Result(column = "updatetime", property = "updateTime"),
            @Result(column = "pid", property = "pid"),
            @Result(column = "pid", property = "project", javaType = Project.class, one =  //一对一关联查询
            @One(select = "com.construction.mapper.ProjectMapper.findProject", fetchType = FetchType.EAGER)
            ),
    })
    @Select("<script>" +
            "select * from branch where status = 1" +
            "<if test = 'bname != null'>" +
            "and bname = #{bname}" +
            "</if>" +
            " limit #{currentPage},#{pageSize}" +
            "</script>")
    List<Branch> findBranchPage(@Param("currentPage") int currentPage, @Param("pageSize") Integer pageSize, @Param("bname") String bname);


    @Select("Select count(*) from branch where status=1")
    Long count();

    @Update("UPDATE branch SET updatetime = now(),status = 0 where bid = #{bid} ")
    int deleteByBid(String bid);

    @Select("select * from branch where bid=#{bid} and status=1")
    BranchDto findBySidDto(String bid);

}