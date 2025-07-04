package com.wzb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wzb.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class StringRedisTemplateTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void testSave() throws JsonProcessingException {
        // 创建对象
        User user = new User("lisi", 25);
        // 手动序列化
        String json = mapper.writeValueAsString(user);
        // 写入数据
        stringRedisTemplate.opsForValue().set("user", json);
        // 获取数据
        String jsonUser = stringRedisTemplate.opsForValue().get("user");
        // 手动反序列化
        User readUser = mapper.readValue(jsonUser, User.class);
        System.out.println(readUser);
    }
}
