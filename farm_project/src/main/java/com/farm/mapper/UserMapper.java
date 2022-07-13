package com.farm.mapper;

import com.farm.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from sys_user where status = 1 limit #{currentPage},#{pageSize}")
    List<SysUser> findPage(Integer currentPage, Integer pageSize);
    @Select("select count(*) from sys_user where status = 1")
    long total();

    @Select("select * from sys_user where status = 1 ")
    List<SysUser> findAll();

    List<SysUser> selectSysUserAll();

    SysUser selectSysUserById(Long id);

    int insertSysUser(SysUser sysUser);

    int updateSysUser(SysUser sysUser);

    int deleteSysUserById(Long id);
}
