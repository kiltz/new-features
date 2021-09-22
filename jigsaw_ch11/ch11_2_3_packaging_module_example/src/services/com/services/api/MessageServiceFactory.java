package com.services.api;

import com.services.api.MessageService;
import com.services.impl.SimpleMessageService;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 *
 * @author Michael Inden
 * <p>
 * Copyright 2017 by Michael Inden
 */
public class MessageServiceFactory {
    public static MessageService createMessageService() {
        return new SimpleMessageService();
    }
}