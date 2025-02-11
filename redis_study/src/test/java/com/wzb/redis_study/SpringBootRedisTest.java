package com.wzb.redis_study;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * SpringBootDataRedis
 */
@SpringBootTest
public class SpringBootRedisTest {

    /**
     * 自动填充RedisTemplate API
     */
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void testString() {
        // 写入一条String数据
        redisTemplate.opsForValue().set("name", "虎哥");
        // 获取String数据
        Object o = redisTemplate.opsForValue().get("name");
        System.out.println(o);
    }
}
