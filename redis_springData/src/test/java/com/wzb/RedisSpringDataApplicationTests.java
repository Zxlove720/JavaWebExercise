package com.wzb;

import com.wzb.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisSpringDataApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void testString() {
        // 存储一条String数据
        redisTemplate.opsForValue().set("name", "jack");
        // 获取String数据
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Test
    void testObject() {
        redisTemplate.opsForValue().set("user", new User("zhangsan", 20));
        User user = (User)redisTemplate.opsForValue().get("user");
        System.out.println(user);
    }

}
