package com.example.redis.controller;

import com.example.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RedisTestController
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/12/3
 * @Version V1.0
 **/
@RestController
@RequestMapping("/redis")
public class RedisTestController {
    @Autowired
    RedisService redisService;
    @GetMapping("/save")
    public String save(String key,String value,int time){
        redisService.set(key,value,time);
        return "save success";
    }
    @GetMapping("/get")
    public String get(String key){
        return redisService.get(key);

    }
}
