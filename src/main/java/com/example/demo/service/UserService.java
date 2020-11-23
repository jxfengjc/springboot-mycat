package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/11/9
 * @Version V1.0
 **/
@Service
public class  UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserEntity> findUser() {
        return userMapper.findUser();
    }

    public List<UserEntity> insertUser(String userName) {
        return userMapper.insertUser(userName);
    }

}
