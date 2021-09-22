package ch3_1_5.optional;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class OptionalOrExample
{
    public static void main(final String[] args)
    {
        final Optional<String> optCustomer = multiFindCustomer("Tim");
        optCustomer.ifPresentOrElse(str -> System.out.println("found: " + str), () -> System.out.println("not found"));
    }

    private static Optional<String> multiFindCustomer(final String customerId)
    {
        return findInCache(customerId)
               .or(() -> findInMemory(customerId))
               .or(() -> findInDb(customerId));
    }

    private static Optional<String> findInMemory(final String customerId)
    {
        System.out.println("findInMemory");
        final Stream<String> customers = Stream.of("Tim", "Tom", "Mike", "Andy");
        
        return customers.filter(name -> name.contains(customerId))
                        .findFirst();
    }
    
    private static Optional<String> findInCache(final String customerId)
    {
        System.out.println("findInCache");
        return Optional.empty();
    }

    private static Optional<String> findInDb(final String customerId)
    {
        System.out.println("findInDb");
        return Optional.empty();
    }
}
