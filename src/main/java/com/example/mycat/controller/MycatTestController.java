package com.example.mycat.controller;

import com.example.mycat.entity.UserEntity;
import com.example.mycat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName MycatTestController
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/11/9
 * @Version V1.0
 **/
@RestController
public class MycatTestController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findUser")
    public List<UserEntity> findUser() {
        return userService.findUser();
    }

    @RequestMapping("/insertUser")
    public String insertUser(String userName) {
        userService.insertUser(userName);
        return "insert success!";
    }
    @RequestMapping("/test")
    public String test(){
        return "success!";
    }
}
