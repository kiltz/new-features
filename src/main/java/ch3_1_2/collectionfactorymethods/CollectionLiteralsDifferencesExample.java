package ch3_1_2.collectionfactorymethods;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen" / "Java Aktuell"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class CollectionLiteralsDifferencesExample
{
    public static void main(final String[] args)
    {
        System.out.println("JDK 8 Collections");
        collectionsExampleJdk8();

        System.out.println("\nJDK 9 Collection Factory Methods");
        collectionsExampleJdk9();
    }

    private static void collectionsExampleJdk8()
    {
        final Set<Integer> numbers = new TreeSet<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(2);
        System.out.println(numbers);

        final Map<Integer, String> mapping = new TreeMap<>();
        mapping.put(5, "five");
        mapping.put(7, "seven");
        mapping.put(6, "six");
        System.out.println(mapping);
    }

    private static void collectionsExampleJdk9()
    {
        final Set<Integer> numbers = Set.of(3, 1, 2);
        System.out.println(numbers);

        final Map<Integer, String> mapping = Map.of(5, "five", 7, "seven", 6, "six");
        System.out.println(mapping);
    }
}
