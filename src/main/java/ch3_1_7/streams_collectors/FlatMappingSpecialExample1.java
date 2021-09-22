package ch3_1_7.streams_collectors;

import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class FlatMappingSpecialExample1 
{
	public static void main(String... args) 
    {
        final List<Integer> fibonacciNumbers = List.of(1, 1, 2, 3, 5, 8, 13, 21);       
        final List<Integer> firstNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        final Predicate<Integer> isEven = i -> i % 2 == 0;
        
        final List<Integer> result = Stream.of(fibonacciNumbers, firstNumbers).collect(
                                     flatMapping(list -> list.stream().filter(isEven),
                                                 toList()));
        System.out.println(result);
    }
}