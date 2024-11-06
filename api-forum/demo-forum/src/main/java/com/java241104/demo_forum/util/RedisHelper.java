package com.java241104.demo_forum.util;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

@Component
public class RedisHelper {
  private RedisTemplate<String, String> redisTemplate;

  public RedisHelper(RedisConnectionFactory redisConnectionFactory) {
    this.redisTemplate = new RedisTemplate<>();
    this.redisTemplate.setConnectionFactory(redisConnectionFactory);
    this.redisTemplate.setKeySerializer(RedisSerializer.string());
    this.redisTemplate.setValueSerializer(RedisSerializer.json());
    this.redisTemplate.afterPropertiesSet();
  }

  public RedisTemplate<String, String> getRedisTemplate() {
    return redisTemplate;
  }
}
