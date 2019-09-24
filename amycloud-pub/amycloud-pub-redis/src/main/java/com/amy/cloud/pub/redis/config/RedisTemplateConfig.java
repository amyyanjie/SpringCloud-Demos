package com.amy.cloud.pub.redis.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/09/21 15:30
 */
@Configuration
@AllArgsConstructor
@EnableCaching //启用缓存
@ConditionalOnBean(RedisConnectionFactory.class)
public class RedisTemplateConfig {
    private final RedisConnectionFactory redisConnectionFactory;

    /**
     * 自定义<String,Object>泛型形式的RedisTemplate
     * 并设置key,value的序列化方式
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        template.setHashValueSerializer(new JdkSerializationRedisSerializer());
        return template;
    }
}
