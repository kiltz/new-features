package ch3_1_5.optional;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ThirdOptionalExample
{
    public static void main(final String[] args)
    {
        final Optional<String> optCustomer1 = findCustomer("Tim");
        ifPresentOrElse(optCustomer1, customer -> System.out.println("found: " + customer),
                        () -> System.out.println("not found"));

        final Optional<String> optCustomer2 = findCustomer("UNKNOWN");
        ifPresentOrElse(optCustomer2, customer -> System.out.println("found: " + customer),
                        () -> System.out.println("not found"));
    }

    private static <T> void ifPresentOrElse(final Optional<T> optional, final Consumer<? super T> action,
                                            final Runnable elseAction)
    {
        if (optional.isPresent())
        {
            action.accept(optional.get());
        }
        else
        {
            elseAction.run();
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
