package com.memposit.scalingspringbootmicroservicecache.configuration;

import com.memposit.scalingspringbootmicroservicecache.receiver.NotificationReceiverImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.concurrent.CountDownLatch;

/**
 * Configuration of beans needed for redis and event listener
 *
 */
@Configuration
public class RedisConfiguration {
    public static final String TOPIC = "messageQueue";


    /**
     * Redis message listener
     *
     * @param connectionFactory Connection Factory
     * @return Configured message listener
     */
    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(messageListener(), new PatternTopic(TOPIC));
        return container;
    }

    @Bean
    public CountDownLatch countDownLatch() {
        return new CountDownLatch(1);
    }

    /**
     * Specify template for event sending used for redis
     *
     * @param connectionFactory Connection Factory
     * @return Configured {@link RedisTemplate}
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }

    /**
     * Return implementation of the message listener
     *
     * @return Implementation ({@link NotificationReceiverImpl})
     */
    @Bean
    public MessageListener messageListener() {
        return new NotificationReceiverImpl();
    }
}
