package ch12_2_2.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ServiceLookup
{
    public static <T> Optional<T> lookup(final Class<T> clazz)
    {
        final Iterator<T> iterator = ServiceLoader.load(clazz).iterator();
        return iterator.hasNext() ? Optional.of(iterator.next()) : Optional.empty();
    }

    public static <T> List<T> lookupAll(final Class<T> clazz)
    {
        final List<T> result = new ArrayList<>();

        final Iterator<T> iterator = ServiceLoader.load(clazz).iterator();
        while (iterator.hasNext())
        {
            result.add(iterator.next());
        }

        return result;
    }
}