package ch3_1_7.streams_collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.filtering;

import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class FilteringGroupingByExample 
{
	public static void main(String[] args) 
	{
	    final Stream<String> programming = Stream.of("Java", "JavaScript", "Groovy",
	                                                 "JavaFX", "Spring", "Java");
        final Predicate<String> containsJava = name -> name.contains("Java");
	       
	    final Map<String, Long> result = 
	                                programming.filter(containsJava).
	                                            collect(groupingBy(str -> str, 
	                                                               counting()));
	    
	    System.out.println(result);
	    
	    final Map<String, Long> result2 =
	                    programming.collect(groupingBy(str -> str,
	                    filtering(containsJava,
	                    counting())));
	    System.out.println(result2);
	}
}
