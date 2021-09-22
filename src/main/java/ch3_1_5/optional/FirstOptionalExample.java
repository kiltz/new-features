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
public class FirstOptionalExample
{
    public static void main(String[] args)
    {
        // Standard
        findCustomer("Tim").ifPresent(System.out::println);
        findCustomer("UNKNOWN").ifPresent(System.out::println);
    }

    private static Optional<String> findCustomer(String customerId)
    {
        System.out.println("findCustomer(" + customerId + ")");
        final Stream<String> customers = Stream.of("Tim", "Tom", "Mike", "Andy");
        if (customers.anyMatch(s -> s.contains(customerId)))
        {
            return Optional.of(customerId);
        }
        return Optional.empty();
    }
}
