package com.inden.javaprofi;

import com.services.api.MessageService;
import com.services.api.MessageServiceFactory;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 *
 * @author Michael Inden
 * <p>
 * Copyright 2017 by Michael Inden
 */
public class MessageExample {
    public static void main(final String[] args) {
        final MessageService messageService = MessageServiceFactory.createMessageService();
        System.out.println("Generated msg: " + messageService.generateMessage());
    }
}