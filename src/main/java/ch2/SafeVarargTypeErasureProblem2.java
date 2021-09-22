package ch2;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class SafeVarargTypeErasureProblem2
{
    // Type safety: Potential heap pollution via varargs parameter elements    
    private static <T> T[] toArray(final T... elements)
    {
        return elements;
    }

    // Type safety: A generic array of T is created for a varargs parameter
    private static <T> T[] combine(final T t1, final T t2)
    {
        return toArray(t1, t2);
    }

    public static void main(final String[] args)
    {
        final String[] strings = toArray("bad", "karma");
        final String[] strings2 = combine("bad", "karma"); // ClassCastException
    }
}
