package com.example.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedisService
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/12/3
 * @Version V1.0
 **/
@Service
public class RedisService {
    @Autowired
    StringRedisTemplate redisTemplate;

    public void set(String key, String value,int time) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key,time, TimeUnit.SECONDS);
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 次数自增
     * @param key
     */
    public void  increment(String key){
        redisTemplate.opsForValue().increment(key);
    }
}
