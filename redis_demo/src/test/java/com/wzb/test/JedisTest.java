package com.wzb.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Jedis测试
 */
public class JedisTest {

    private Jedis jedis;

    @BeforeEach
    void setUp() {
        // 建立连接
        jedis = new Jedis("192.168.181.134", 6379);
        // 设置密码
        jedis.auth("262460wzbWZB...");
        // 选择库
        jedis.select(0);
    }

    @Test
    void testString() {
        // 存入数据
        String result = jedis.set("username", "jack");
        System.out.println(result);
        // 获取数据
        String username = jedis.get("username");
        System.out.println(username);
    }

    @Test
    void testHash() {
        Map<String, String> student = new HashMap<>();
        student.put("name", "张三");
        student.put("gender", "男");
        student.put("age", "20");
        student.put("address", "重庆");
        student.put("phone", "13100000001");
        String result = jedis.hmset("student", student);
        System.out.println(result);
        List<String> studentField = jedis.hmget("student", "name", "gender", "age");
        System.out.println(studentField);
    }

    @AfterEach
    void close() {
        if (jedis != null) {
            jedis.close();
        }
    }

}
