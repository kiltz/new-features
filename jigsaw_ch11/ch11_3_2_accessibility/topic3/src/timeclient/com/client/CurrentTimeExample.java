package com.client;

import com.server.TimeInfo;
import java.lang.reflect.Method;
import java.lang.Class;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class CurrentTimeExample
{
    public static void main(final String[] args) throws Exception
    {
        System.out.println("Trying to access getCurrentTime() via reflection");
        
        final ClassLoader classLoader = CurrentTimeExample.class.getClassLoader();

        final Class<?> internalClass = classLoader.loadClass("com.server.internal.InternalUtil");

        final Method method = internalClass.getMethod("getCurrentTime");
        method.setAccessible(true);
        final Object result = method.invoke(null, new Object[0]);
            
        System.out.println("getCurrentTime() returned: " + result);
    }
}