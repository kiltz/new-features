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
public class SecondOptionalExample
{
    public static void main(String[] args)
    {
        // Aktion im Not-Found-Fall
        final Optional<String> optCustomer1 = findCustomer("Tim");
        if (optCustomer1.isPresent())
        {
            System.out.println("found: " + optCustomer1.get());
        }
        else
        {
            System.out.println("not found");
        }

        final Optional<String> optCustomer2 = findCustomer("UNKNOWN");
        if (optCustomer2.isPresent())
        {
            System.out.println("found: " + optCustomer2.get());
        }
        else
        {
            System.out.println("not found");
        }
    }

    private static Optional<String> findCustomer(String customerId)
    {
        System.out.println("findCustomer(" + customerId + ")");
        final Stream<String> customers = Stream.of("Tim", "Tom", "Mike", "Andy");
        if (customers.anyMatch(name -> name.contains(customerId)))
        {
            return Optional.of(customerId);
        }
        return Optional.empty();
    }
}
