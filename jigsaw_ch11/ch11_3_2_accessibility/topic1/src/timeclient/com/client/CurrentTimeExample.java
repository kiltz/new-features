package com.client;

import com.server.TimeInfo;
import com.server.internal.InternalUtil;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class CurrentTimeExample
{
    public static void main(final String[] args)
    {
        System.out.println("Now: " + TimeInfo.getCurrentTime());
        System.out.println("Now: " + InternalUtil.getCurrentTime());
    }
}