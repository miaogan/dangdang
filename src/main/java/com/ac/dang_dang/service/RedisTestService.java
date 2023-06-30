package com.ac.dang_dang.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Slf4j
public class RedisTestService {
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    public void add(){
        int keyId = ThreadLocalRandom.current().nextInt(1000)+1;
        String serialNo= UUID.randomUUID().toString();
        String key = String.format("test_%04d", keyId);
        byte[] bytes = serialNo.getBytes();
        String value = "京东" + new String(bytes);
        redisTemplate.opsForValue().set(key, value);
        log.info("{}{}", key, value);
    }

    public String get(Integer keyId){
        String key = String.format("test_%04d", keyId);
        return redisTemplate.opsForValue().get(key);
    }
}