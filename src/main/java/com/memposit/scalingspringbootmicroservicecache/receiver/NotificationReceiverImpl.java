package com.memposit.scalingspringbootmicroservicecache.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

/**
 * Implementation for the {@link MessageListener}
 *
 */
@Slf4j
public class NotificationReceiverImpl implements MessageListener {
    private final GenericJackson2JsonRedisSerializer redisSerializer = new GenericJackson2JsonRedisSerializer();

    @Override
    public void onMessage(Message message, byte[] bytes) {
        log.info("Parsed message content_ {} >> {}", getChannel(message), getPayload(message));
        log.info("Raw message: {}", deserialize(message));
    }

    private String getChannel(Message message) {
        return new String(message.getChannel());
    }

    private Object getPayload(Message message) {
        return redisSerializer.deserialize(message.getBody());
    }

    private Object deserialize(Message message) {
        return message.toString();
    }
}
