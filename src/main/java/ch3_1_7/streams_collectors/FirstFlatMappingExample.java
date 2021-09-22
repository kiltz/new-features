package ch3_1_7.streams_collectors;

import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class FirstFlatMappingExample
{
    public static void main(String[] args)
    {

        final Stream<Map.Entry<String, Set<String>>> nameToHobbies = Stream
                        .of(Map.entry("Peter", Set.of("Groovy", "Movies")),
                            Map.entry("Peter", Set.of("Java", "Skating")), Map.entry("Micha", Set.of("Java")),
                            Map.entry("Micha", Set.of("HiFi", "Cycling")));

        final Map<String, Set<String>> collectedHobbies = nameToHobbies
                        .collect(groupingBy(entry -> entry.getKey(),
                                            flatMapping(entry -> entry.getValue().stream(), toSet())));

        System.out.println(collectedHobbies);
    }
}
