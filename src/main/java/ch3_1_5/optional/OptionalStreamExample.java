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
public class OptionalStreamExample
{
    public static void main(final String[] args)
    {
        final Stream<Optional<String>> streamOfOptionalNames = Stream.of(Optional.of("Tim"), Optional.of("Tom"),
                                                                         Optional.empty(), Optional.of("Mike"),
                                                                         Optional.empty(), Optional.of("Andy"));

        final Stream<String> streamOfNamens = streamOfOptionalNames.flatMap(Optional::stream);
        streamOfNamens.forEach(value -> System.out.println("found: " + value));
    }
}
