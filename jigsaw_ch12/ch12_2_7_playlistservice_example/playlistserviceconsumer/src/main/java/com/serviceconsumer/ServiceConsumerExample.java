package com.serviceconsumer;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Optional;

import com.javaprofi.spi.PlaylistService;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ServiceConsumerExample
{
    public static void main(final String[] args) throws Exception
    {
        final Optional<PlaylistService> optService = lookup(PlaylistService.class);

        optService.ifPresentOrElse(service -> 
        {
            System.out.println(service.getClass());

            final List<String> allTitles = service.getTitles();
            System.out.println("All titles: " + allTitles);
        }, 
        () -> System.err.println("No service provider found!"));        
    }

    private static <T> Optional<T> lookup(final Class<T> clazz)
    {
        final Iterator<T> iterator = ServiceLoader.load(clazz).iterator();
        return iterator.hasNext() ? Optional.of(iterator.next()) : Optional.empty();
    }
}