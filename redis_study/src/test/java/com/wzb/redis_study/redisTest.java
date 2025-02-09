package com.wzb.redis_study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

public class redisTest {

    private Jedis jedis;

    /**
     * redis建立连接
     */
    @BeforeEach
    void setUp() {
        // 建立连接
        jedis = new Jedis("192.168.181.129", 6379);
        // 设置密码
        jedis.auth("123456");
        // 选择库（默认0）
        jedis.select(0);
    }

    /**
     * 测试String数据类型
     */
    @Test
    void testString() {
        // 存
        String result = jedis.set("name", "张三");
        System.out.println(result);
        // 取
        String name = jedis.get("name");
        System.out.println(name);
    }

}
