package ch3_1_10.objects;

import java.util.Objects;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ObjectsNonNullExample
{
    public static void main(final String[] args)
    {
        System.out.println(generateMsg(null, null));
    }

    private static String generateMsg(final String msg, final String param)
    {
        final String message = Objects.requireNonNullElse(msg, "Default-Msg");
        final String parameter = Objects.requireNonNullElseGet(param, () -> "No Param");

        return message + " : " + parameter;
    }
}
