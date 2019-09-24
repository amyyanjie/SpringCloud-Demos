package com.amy.cloud.pub.redis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/09/24 15:43
 */
@Component
public class RedisUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisUtil.class);

    private RedisTemplate<String, Object> redisTemplate;

    //========================common========================

    /**
     * 更新缓存过期时间
     */
    public boolean expire(String key, long time) {

        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取过期时间
     */
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    /**
     * 判断key是否存在
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存
     */
    public void delete(final String key) {
        if (hasKey(key)) {
            redisTemplate.delete(key);
        }
    }

    public void delete(String... keys) {
        for (String key : keys) {
            delete(key);
        }
    }

    //========================String========================
    public boolean set(final String key, Object value, Long expireTime) {
        try {
            redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object get(final String key) {
        Object result = redisTemplate.opsForValue().get(key);
        if (result == null) {
            return null;
        }
        return result;
    }
}
