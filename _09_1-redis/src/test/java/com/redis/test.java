package com.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.redis
 * @Author: mos
 * @CreateTime: 2022-07-13  09:24
 * @Description: TODO
 * @Version: 1.0
 */
public class test {
    @Test
    public void test1() {
        Jedis jedis = new Jedis("192.168.211.130", Integer.parseInt("6379"));
        jedis.auth("1234");
        String set = jedis.set("jedis", "jjjjj");
        System.out.println(set);


    }

    @Test
    public void test2() {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        String host = "192.168.211.130";
        int port = 6379;
        int timeout = 3000;
        String password = "1234";
        JedisPool jedisPool = new JedisPool(poolConfig, host, port,timeout ,password);
        Jedis resource = jedisPool.getResource();




        resource.close();
    }
}
