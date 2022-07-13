package com.farm.mapper;

import com.farm.model.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionMapper {

    @Select("Select id,path,title,link_url as linkUrl,parent_id,icon from permission where parent_id =#{id} ")
    List<Permission> findAll(int id);
}