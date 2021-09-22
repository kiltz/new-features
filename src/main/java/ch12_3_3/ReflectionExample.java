package ch12_3_3;

import java.lang.reflect.Method;
import java.net.URL;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ReflectionExample
{
    public static void main(final String[] args) throws Exception
    {
        final Method method = URL.class.getDeclaredMethod("getURLStreamHandler", String.class);
        method.setAccessible(true);
        
        System.out.println(method.invoke(null, "http"));
    }
}
