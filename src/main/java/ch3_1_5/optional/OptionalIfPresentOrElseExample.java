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
public class OptionalIfPresentOrElseExample
{
    public static void main(final String[] args)
    {
        final Optional<String> optCustomer1 = findCustomer("Tim");
        optCustomer1.ifPresentOrElse(str -> System.out.println("found: " + str), () -> System.out.println("not found"));

        final Optional<String> optCustomer2 = findCustomer("UNKNWON");
        optCustomer2.ifPresentOrElse(str -> System.out.println("found: " + str), () -> System.out.println("not found"));
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
