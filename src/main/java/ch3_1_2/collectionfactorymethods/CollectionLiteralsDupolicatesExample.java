package ch3_1_2.collectionfactorymethods;

import java.util.List;
import java.util.Set;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen" / "Java Aktuell"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class CollectionLiteralsDupolicatesExample
{
    public static void main(final String[] args)
    {
        final List<String> names = List.of("MAX", "MORITZ", "MAX");
        names.forEach(name -> System.out.println(name));
      
        final Set<String> names2 = Set.of("MAX", "MORITZ", "MAX");
        names2.forEach(name -> System.out.println(name));
    }
}