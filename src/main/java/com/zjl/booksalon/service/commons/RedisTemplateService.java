package com.zjl.booksalon.service.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: ZJL
 * @Date: 2022/3/27 22:44
 * @Description:
 */
@Service
public class RedisTemplateService {

    @Autowired
    private RedisTemplate<String, String> template;

    public void setMailCode(String key, String value) {
        //更改在redis里面查看key编码问题
        RedisSerializer redisSerializer = new StringRedisSerializer();
        template.setKeySerializer(redisSerializer);
        ValueOperations<String, String> operations = template.opsForValue();
        //设置验证码过期的时间
        operations.set(key, value, 60, TimeUnit.SECONDS);
    }

    public void saveToken(String key, String value) {
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        ValueOperations<String, String> operations = template.opsForValue();
        operations.set(key, value, 11, TimeUnit.HOURS);
    }

    public String get(String key) {
        ValueOperations<String, String> operations = template.opsForValue();
        return operations.get(key);
    }

    public Boolean delete(String key) {
        return Boolean.TRUE.equals(template.delete(key));
    }

    public String getAndDelete(String key) {
        ValueOperations<String, String> opsForValue = template.opsForValue();
        return opsForValue.getAndDelete(key);
    }
}
