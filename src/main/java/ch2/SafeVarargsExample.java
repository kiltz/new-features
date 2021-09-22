package ch2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class SafeVarargsExample
{
    public static void main(final String[] args)
    {
        final Optional<String> first = new SafeVarargsExample().firstOrEmpty("A", "B", "C");

        new SafeVarargsExample().m(List.of("A", "B", "C"));
    }

    @SafeVarargs
    private void m(final List<String>... stringLists)
    {
        final Object[] array = stringLists;
        final List<Integer> tmpList = Arrays.asList(42);
        
        // Semantically invalid, but compiles without warnings
        array[0] = tmpList; 
        // ClassCastException at runtime!
        final String s = stringLists[0].get(0); 
    }

    @SafeVarargs
    private <T> Optional<T> firstOrEmpty(final T... args)
    {
        if (args.length > 0)
        {
            return Optional.of(args[0]);
        }
        return Optional.empty();        
    }
}
