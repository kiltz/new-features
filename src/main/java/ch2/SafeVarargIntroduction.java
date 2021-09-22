package ch2;

import java.util.Arrays;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class SafeVarargIntroduction
{
    // Simple Methode mit Vararg-Parameter
    private static <T> void printAll(T... elements)
    {
        for (final T elem : elements)
        {
            System.out.println(elem + " of type " + elem.getClass());
        }
    }

    public static void main(final String[] args)
    {
        printAll("Hello", "Varargs");

        // Type safety: A generic array of List<String> is created for a varargs parameter
        printAll(Arrays.asList("A", "B"), Arrays.asList("C", "D"));
    }
}
