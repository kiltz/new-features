package ch3_1_additional.reflection_and_more;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class GreetingUtils
{
    public int sayHello(final String name)
    {
        final String message = "Hello " + name;
        System.out.println(message);
        return message.length();
    }

    public static void say(final String name)
    {
        final String message = "Hello " + name;
        System.out.println(message);
    }
}