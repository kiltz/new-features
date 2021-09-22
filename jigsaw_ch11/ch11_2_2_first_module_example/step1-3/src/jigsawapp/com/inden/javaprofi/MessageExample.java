package com.inden.javaprofi;

import com.services.MessageService;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class MessageExample 
{
	public static void main(final String[] args) 
	{
       System.out.println("Generated msg: " + MessageService.generateMessage());
    }
}