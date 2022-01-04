package com.bonjour.demo.test.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis 监听配置类
 * @authur tc
 * @date 2021/11/22 21:13
 */
@Configuration
public class RedisListenerConfig {

    @Autowired
    private RedisTemplate redisTemplate;

    @Bean
    public RedisTemplate initRedisTemplate() {
        // key 序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // value 实例化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }

    /**
     * redis 监听容器
     * @param connectionFactory
     * @return
     */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        return container;
    }
}
