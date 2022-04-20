package com.redis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * TODO: 
 *
 * @author djq
 * @date 2021/8/17 15:52
 */
@Slf4j
@Controller
@RequestMapping("/redis")
public class Redis学习 {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @GetMapping("addRedis")
    public Map<String,Object> addRedis(){
        Map<String,String> map = new HashMap<>();
        map.put("school","齐武路小学");
        map.put("grade","一年级");
        map.put("class","一班");
        map.put("name","芬达");
        //存入字符串
        redisTemplate.opsForValue().set("son",map,10, TimeUnit.SECONDS);
        log.info("key值为son的存储值:{}",redisTemplate.opsForValue().get("son"));
        //拆分成key-value存入
        redisTemplate.opsForValue().multiSet(map);
        List<String> keys = new ArrayList<String>();
        keys.add("school");
        keys.add("grade");
        keys.add("class");
        keys.add("name");
        log.info("多建分别设置值的存储值:{}",redisTemplate.opsForValue().multiGet(Collections.singleton(keys)));
        map.put("grade","二年级");
        map.put("class","二班");
        //设置建的字符串值并返回旧值
        Map<String,Object> oldMap = (Map<String, Object>) redisTemplate.opsForValue().getAndSet("son",map);
        log.info("旧值：{}",oldMap);
        log.info("新值：{}",redisTemplate.opsForValue().get("son"));
        //插入整数、浮点数
        redisTemplate.opsForValue().increment("double",2.21);
        log.info("插入的浮点数：{}",redisTemplate.opsForValue().get("double"));
        //字符串尾端追加存储
        redisTemplate.opsForValue().append("appendTest","hello");
        log.info("appendTest的初始值",redisTemplate.opsForValue().get("appendTest"));
        redisTemplate.opsForValue().append("appendTest","world");
        log.info("appendTest的追加后的值",redisTemplate.opsForValue().get("appendTest"));
        log.info("appendTest存储值的长度：{}",redisTemplate.opsForValue().size("appendTest"));
        log.info("appendTest截取值：{}",redisTemplate.opsForValue().get("appendTest",5,10));

        System.out.println(map);
        Map<String,Object> result = (Map<String, Object>) redisTemplate.opsForValue().get("son");
        System.out.println(result);
        return result;
    }

    @DeleteMapping("delRedis")
    public String delRedis(String key){
        Boolean bool = redisTemplate.delete(key);
        return bool ? "删除成功" : "删除失败";
    }

}
