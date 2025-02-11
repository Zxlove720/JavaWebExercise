package com.wzb.redis_study;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wzb.redis_study.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

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

    /**
     * 使用RedisTemplate子类，默认序列化是String方式，可以减少存储大小
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 测试String数据类型
     */
    @Test
    void testString() {
        // 写入一条String数据
        redisTemplate.opsForValue().set("name", "虎哥");
        // 获取String数据
        Object o = redisTemplate.opsForValue().get("name");
        System.out.println(o);
    }

    /**
     * 测试存储对象
     */
    @Test
    void testObject() {
        // 写入一条String数据，value是对象
        User user = new User("虎哥", 18);
        redisTemplate.opsForValue().set("user", user);
        // 获取数据
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    // 序列化对象
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * 测试String序列化方式
     */
    @Test
    void testUser() throws JsonProcessingException {
        User user = new User("虎哥", 21);
        // 手动序列化
        String json = mapper.writeValueAsString(user);
        // 手动写入数据
        stringRedisTemplate.opsForValue().set("user:200", json);
        // 获取数据
        String jsonUser = stringRedisTemplate.opsForValue().get("user:200");
        // 手动反序列化
        User user1 = mapper.readValue(jsonUser, User.class);
        System.out.println(user1);
    }
}
