package com.services.impl;

import com.services.api.MessageService;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 *
 * @author Michael Inden
 * <p>
 * Copyright 2017 by Michael Inden
 */
public class SimpleMessageService implements MessageService {
    public String generateMessage() {
        return "Message from module services!";
    }
}