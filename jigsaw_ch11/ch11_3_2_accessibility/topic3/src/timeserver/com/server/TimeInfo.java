package com.server;

import java.time.LocalDateTime;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class TimeInfo
{
	public static LocalDateTime getCurrentTime()
	{
		return LocalDateTime.now();
	}   
}