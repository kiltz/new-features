package ch3_1_7.streams_collectors;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.toSet;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class FirstFilteringExample 
{
	public static void main(String[] args) 
	{
	    final Stream<String> programming1 = Stream.of("Java", "JavaScript", "Groovy",
	                                              "JavaFX", "Spring", "Java");
	    final Stream<String> programming2 = Stream.of("Java", "JavaScript", "Groovy",
	                                              "JavaFX", "Spring", "Java");
	    
	    final Predicate<String> containsJava = name -> name.contains("Java");
	    final Set<String> result1 = programming1.filter(containsJava).
	                                             collect(toSet());
	    
	    // Mit Filtering Collector:
	    final Set<String> result2 = programming2.collect(filtering(containsJava,
	                                                               toSet()));
	
	}
}
