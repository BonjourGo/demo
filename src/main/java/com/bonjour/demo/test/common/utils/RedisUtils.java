package com.bonjour.demo.test.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @authur tc
 * @date 2021/9/27 15:58
 */
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     *  redis 获得自增id 有前缀
     * @param keyPrefix
     * @return
     */
    public String getIncrId(String keyPrefix) {
        // 格式化时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String formatDate = simpleDateFormat.format(date);
        // 获取自增
        RedisAtomicLong redisAtomicLong = new RedisAtomicLong(formatDate, redisTemplate.getConnectionFactory());
        Long incr = redisAtomicLong.incrementAndGet();
        // 自增起始号码
        DecimalFormat decimalFormat = new DecimalFormat("0000000000");
        String value = decimalFormat.format(incr);
        String id = keyPrefix + formatDate + value;
        return id;
    }

    /**
     * 设置redis键值对
     *
     * @param key   redis键
     * @param value redis值
     */
    public <T> void setCacheObject(final String key, final T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置redis键值对
     *
     * @param key      redis键
     * @param value    redis值
     * @param timeout  过期时间
     * @param timeUnit 时间单位
     */
    public <T> void setCacheObjectAndExpire(final String key, final T value, final Integer timeout, final TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    /**
     * 获取Redis缓存
     * @param key
     * @param <T>
     * @return
     */
    public <T> Object getCacheObject(final String key) {
        Object result = redisTemplate.opsForValue().get(key);
        return result;
    }

    /**
     * 获取自增值从1开始 无前缀
     * @param key
     * @return
     */
    public Long getIncrLongId(String key) {
        return (Long) redisTemplate.execute((RedisCallback<Long>) connection -> {
            RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
            byte[] keys = serializer.serialize("sequence:id_" + key);
            return connection.incr(keys);
        } );
    }

    /**
     * 删除单个对象
     *
     * @param key redis键
     * @return boolean
     */
    public boolean deleteObject(final String key) {
        return redisTemplate.delete(key);
    }
}
