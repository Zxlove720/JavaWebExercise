package com.wzb.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {

    private static final JedisPool jedisPool;

    static {
        // 配置连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 设置连接池最大连接数
        poolConfig.setMaxTotal(8);
        // 设置连接池最大空闲连接数
        poolConfig.setMaxIdle(8);
        // 设置连接池最小空闲连接数
        poolConfig.setMaxIdle(4);
        // 设置连接池最大等待时间
        poolConfig.setMaxWaitMillis(1000);
        // 创建连接池对象
        jedisPool = new JedisPool(poolConfig, "192.168.181.134", 6379,
                1000, "262460wzbWZB...");
    }

    public static Jedis getConnection() {
        return jedisPool.getResource();
    }
}
