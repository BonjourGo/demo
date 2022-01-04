package com.bonjour.demo.test.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @authur tc
 * @date 2021/11/19 11:24
 */
@Configuration
public class RedisPoolFactory {

    private int maxIdle = 500;
    private int maxTotal = 500;
    private int maxWait = 500;


    @Bean
    public JedisPool JedisPoolFactory() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(maxIdle);
        config.setMaxTotal(maxTotal);
        config.setMaxWaitMillis(maxWait * 1000);
        JedisPool jp = new JedisPool(config, "127.0.0.1", 6379,
                10*1000, "", 1);
        return jp;
    }
}
