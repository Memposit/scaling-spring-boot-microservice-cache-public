package com.memposit.scalingspringbootmicroservicecache.controller;

import com.memposit.scalingspringbootmicroservicecache.service.SenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The controller for sending messages, this can be a controller sending messages to a websocket in
 * background and use redis to scale across multiple instances
 *
 */
@RestController
@RequiredArgsConstructor
public class SendController {
    private static int count;

    private final SenderService senderService;

    /**
     * Request Mapping for sending a message via redis, encapsulated in the {@link SenderService}
     */
    @GetMapping("/send")
    public void send() {
        senderService.send("Message: " + count++);
    }
}
