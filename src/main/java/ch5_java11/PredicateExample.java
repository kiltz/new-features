package ch5_java11;

import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class PredicateExample 
{
	public static void main(final String[] args) 
	{	
		final Stream<String> names = Stream.of("Tim", "Tom", "", "", "Mike");
		
		// JDK 10 style
		final Predicate<String> isEmpty = String::isEmpty; 
		final Predicate<String> notEmptyJdk10 = isEmpty.negate();

		// JDK 11 style
		//final Predicate<String> notEmptyJdk11 = Predicate.not(String::isEmpty);
		final Predicate<String> notEmptyJdk11 = not(String::isEmpty);
	}
}
