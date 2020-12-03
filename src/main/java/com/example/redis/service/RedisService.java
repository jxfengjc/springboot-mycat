package com.example.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

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

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
