package com.example.mycat.mapper;
import com.example.mycat.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/11/9
 * @Version V1.0
 **/
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM  user_info ")
    public List<UserEntity> findUser();

    @Select("insert into user_info values (null,#{userName}); ")
    public List<UserEntity> insertUser(@Param("userName") String userName);
}
