package ch2;

import java.util.ArrayList;
import java.util.List;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class SafeVarargTypeErasureProblem
{
    // Simple Methode mit Vararg-Parameter
    @SafeVarargs
    private static <T> void printAll(final T... elements)
    {
        for (final T elem : elements)
        {
            System.out.println(elem + " of type " + elem.getClass());
        }
    }

    public static void main(final String[] args)
    {
        final List<Integer> integers = new ArrayList<>();
        integers.add(Integer.valueOf(1));
        integers.add(2);

        printAll(integers, "End", 4711);
    }
}
