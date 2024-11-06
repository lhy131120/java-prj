package com.java241104.demo_forum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java241104.demo_forum.util.RedisHelper;

@Configuration
public class AppConfig {
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  // @Bean
  // RedisTemplate<String, String> redisTemplate(
  // RedisConnectionFactory redisConnectionFactory) {
  // RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
  // redisTemplate.setConnectionFactory(redisConnectionFactory);
  // redisTemplate.setKeySerializer(RedisSerializer.string());
  // redisTemplate.setValueSerializer(RedisSerializer.json());
  // redisTemplate.afterPropertiesSet();
  // return redisTemplate;
  // }

  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

}
