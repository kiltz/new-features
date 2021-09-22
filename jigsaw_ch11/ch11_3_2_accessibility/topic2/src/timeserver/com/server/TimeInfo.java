package com.server;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	    Logger.getGlobal().log(Level.INFO, "getCurrentTime() called");
		return LocalDateTime.now();
	}   
}