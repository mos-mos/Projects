package com.construction.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.construction.model.Developer;
import com.construction.model.Project;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface ProjectMapper extends BaseMapper<Project> {
    //    @Select("Select * from project where status =1 limit #{currentPage},#{pageSize}")
//    List<Project> findPage(@Param("currentPage")Integer currentPage, @Param("pageSize") Integer pageSize);
//
    @Select("select count(*) from project where status=1")
    Long count();
    //分页查询  limit  0,10
    //通过注解的方式实现映射
    //@Results 等价于 <ResultMap>标签
    //@Result  等价于<result>标签  column字段
    @Results(id = "projectMap", value = {
            @Result(column = "pid", property = "pid"),
            @Result(column = "pname", property = "pName"),
            @Result(column = "starttime", property = "startTime"),
            @Result(column = "endtime", property = "endTime"),
            @Result(column = "updatetime", property = "updateTime"),
            @Result(column = "did", property = "developer", javaType = Developer.class, one =
                    //FetchType.LAZY 懒加载   EAGER:立即加载
                    //select 代表的关联查询  调用指定的mapper方法
            @One(select = "com.construction.mapper.DevelopMapper.findByDid", fetchType = FetchType.EAGER)
            )
    })
    @Select("select * from project where status = 1 limit #{currentPage},#{pageSize}")
    List<Project> findPage(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);


//    String querySql = "SELECT pro.*, dev.* FROM project AS pro LEFT JOIN developer AS dev ON dev.did = pro.did ";
//    String wrapperSql = "SELECT * from ( " + querySql + " ) AS q ${ew.customSqlSegment}";

}
