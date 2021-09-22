package ch3_1_6.streams;

import static java.util.stream.Collectors.joining;

import java.util.stream.IntStream;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class StreamsIterateExample 
{
    public static void main(final String[] args)
    {
        System.out.println("iterate with predicate");

        final IntStream stream = IntStream.iterate(1, n -> n < 10, n -> n + 1);
        System.out.println(stream.mapToObj(num -> "" + num).collect(joining(", ")));
    }
}
