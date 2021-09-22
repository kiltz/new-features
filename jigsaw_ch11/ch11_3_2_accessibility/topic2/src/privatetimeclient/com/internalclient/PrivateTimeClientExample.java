package com.client2;

import java.io.IOException;

import com.server.internal.InternalUtil;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class PrivateTimeClientExample 
{
    public static void main(final String[] args) throws IOException
    {
        System.out.println(InternalUtil.getCurrentTime());
    }
}
