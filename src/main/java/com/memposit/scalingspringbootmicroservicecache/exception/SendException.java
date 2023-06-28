package com.memposit.scalingspringbootmicroservicecache.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Send exception.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SendException extends RuntimeException {

    /**
     * Instantiates a new Send exception.
     *
     * @param cause the cause
     */
    public SendException(String cause) {
        super("Error sending message: " + cause);
    }
}
