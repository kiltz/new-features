package ch12_2_2.client;

import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;

import ch12_2_2.spi.PlaylistService;

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
        System.out.println("Service: " + service.getClass());

        final List<String> allTitles = service.getTitles();
        System.out.println("All titles: " + allTitles);
    }, 
    () -> System.err.println("No service provider found!"));
    }

    private static <T> Optional<T> lookup(final Class<T> clazz)
    {
    	return ServiceLoader.load(clazz).findFirst();
    	/*
        final Iterator<T> iterator = ServiceLoader.load(clazz).iterator();

        if (iterator.hasNext())
        {
            return Optional.of(iterator.next());
        }
        return Optional.empty();
        */
    }
}
