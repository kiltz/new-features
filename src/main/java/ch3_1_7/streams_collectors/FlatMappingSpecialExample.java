package ch3_1_7.streams_collectors;

import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden
 */
public class FlatMappingSpecialExample
{
    public static void main(final String... args)
    {
        final List<Integer> fibonacciNumbers = List.of(1, 1, 2, 3, 5, 8, 13, 21);
        final List<Integer> primeNumbers = List.of(2, 3, 5, 7, 9, 11, 13, 15);
        final List<Integer> naturalNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        final Predicate<Integer> sevenOrMore = i -> i >= 7;

        final Stream<List<Integer>> inputs = Stream.of(fibonacciNumbers, primeNumbers, naturalNumbers);

        final Map<Integer, Set<Integer>> sizeToOddNumbers = inputs
                        .collect(groupingBy(Collection::size, flatMapping(list -> list.stream().filter(sevenOrMore),
                                                                          toCollection(TreeSet::new))));
        System.out.println(sizeToOddNumbers);
    }
}