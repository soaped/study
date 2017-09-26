package com.study.yfz;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by ipaynow0929 on 2017/9/26.
 */
@RestController
public class RedisController {

    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping("/saveRedis")
    public String save(String name){
        redisTemplate.opsForValue().set("name",name,100,TimeUnit.SECONDS);
        return "OK";
    }

    @RequestMapping("/getRedis")
    public String getRedis(){
        String name = (String) redisTemplate.opsForValue().get("name");
        return name;
    }
}
