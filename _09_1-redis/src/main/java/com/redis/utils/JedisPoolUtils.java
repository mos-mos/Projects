package com.redis.utils;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.redis.utils
 * @Author: mos
 * @CreateTime: 2022-07-13  10:04
 * @Description: TODO
 * @Version: 1.0
 */
public class JedisPoolUtils {
    private static Jedis jedis = null;
    private static String host = "192.168.211.130";
    private static int port = 6379;
    private static int timeout = 3000;
    private static String password = "1234";
    static {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        JedisPool jedisPool = new JedisPool(poolConfig, host, port,timeout ,password);
        jedis = jedisPool.getResource();
    }
    public Jedis getJedis() {
        return jedis;
    }
}
