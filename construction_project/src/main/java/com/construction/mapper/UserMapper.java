package com.construction.mapper;

import com.construction.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("Select * from user where username=#{username}")
    User findUserByUsername(String username);
}
