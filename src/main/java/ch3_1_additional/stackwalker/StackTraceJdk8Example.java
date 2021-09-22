package ch3_1_additional.stackwalker;

import java.util.Arrays;
import java.util.List;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class StackTraceJdk8Example
{
    public static void main(final String[] args)
    {
        first();
    }

    private static void first()
    {
        second();
    }

    private static void second()
    {
        final List<StackTraceElement> stackframes = provideStackframesJdk8();
        stackframes.forEach(System.out::println);
    }

    private static List<StackTraceElement> provideStackframesJdk8()
    {
        final StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return Arrays.asList(stackTraceElements);
    }
}
