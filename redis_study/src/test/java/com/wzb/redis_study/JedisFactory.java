package com.wzb.redis_study;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis连接池
 */
public class JedisFactory {

    private static final JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 设置总的最大连接
        jedisPoolConfig.setMaxTotal(8);
        // 设置最大空闲连接
        jedisPoolConfig.setMaxIdle(8);
        // 设置最小空闲连接
        jedisPoolConfig.setMinIdle(2);
        // 设置等待时间
        jedisPoolConfig.setMaxWaitMillis(1000);

        jedisPool = new JedisPool(jedisPoolConfig, "192.168.181.129", 6379, 1000, "123456");
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
