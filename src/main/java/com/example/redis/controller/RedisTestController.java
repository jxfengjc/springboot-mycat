package com.example.redis.controller;

import com.example.fangshua.AccessLimit;
import com.example.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
    @Autowired
    Environment env;
    @GetMapping("/save")
    public String save(String key,String value,int time){
        redisService.set(key,value,time);
        return "save success";
    }
    @AccessLimit(seconds = 5,maxCoint = 2,needLogin = false)
    @GetMapping("/get")
    public String get(String key){
        return redisService.get(key);

    }
    @GetMapping("/getFile")
    public String getpre(){
        String file=  env.getActiveProfiles()[0];
        return file;

    }
}
