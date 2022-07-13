package com.batch.mapper;

import com.batch.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.batch.mapper
 * @Author: mos
 * @CreateTime: 2022-07-07  11:00
 * @Description: userMapper
 * @Version: 1.0
 */
@Mapper
public interface UserMapper {
    void insertBatch(@Param("userList") List<User> userList);

}
