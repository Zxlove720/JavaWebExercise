package com.wzb.redis_study;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

public class redisTest {

    /**
     * redis建立连接
     */
    @BeforeEach
    void setUp() {
        // 建立连接
        Jedis jedis = new Jedis("192.168.181.129", 6379);
        // 设置密码
        jedis.auth("123456");
        // 选择库（默认0）
        jedis.select(0);
    }

}
