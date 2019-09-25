package com.amy.cloud.pub.redis.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * @Author: yanjie
 * @Description: RedisTemplate配置
 * @Date: 2019/09/21 15:30
 */
@Configuration
//@ConditionalOnBean(RedisConnectionFactory.class) //注掉此注解，启动服务时才能运行此配置类
@AllArgsConstructor
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
