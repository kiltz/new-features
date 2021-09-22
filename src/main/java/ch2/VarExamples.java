package ch2;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class VarExamples 
{
	public static void main(final String[] args) 
	{		
		var mike = new Person("Mike", 47);
		var peter = new Person("Peter", 42);
		var name = "Peter";
		var i = 7;
		
		var names = new ArrayList<String>();
		names.add("Tim");
		names.add("Tom");
		names.add("Mike");
		//names.add(42);
		
		var personAgeMapping = Map.of("Tim", 47L, "Tom", 12L, "Mike", 47L, "Max", 25L);
		
		// var wäre hier vielleicht wünschenswert, aber leider nicht möglich, da Compiler den Typ nicht ermitteln kann
		final Function<Map.Entry<String, Long>, Character> firstChar = entry -> entry.getKey().charAt(0);
		final Predicate<Map.Entry<String, Long>> isAdult = entry -> entry.getValue() >= 18;
		Predicate<Map.Entry<String, Long>> isAdult3 = (Map.Entry<String, Long> entry) -> entry.getValue() >= 18;
		var isAdult4 = (Predicate<Map.Entry<String, Long>>) entry -> entry.getValue() >= 18;		

		// var ist hier cool
		var entries = personAgeMapping.entrySet();
		var filteredPersons = personAgeMapping.entrySet().stream().
							                              collect(groupingBy(firstChar, 
							                                      filtering(isAdult, toSet())));
		System.out.println(filteredPersons);
		
		// Compile-Error
		// var => ArrayList<String>
//	    var names = new ArrayList<String>(); 
//		names = new LinkedList<String>(); // error
		
		// Fallstrick: 
		//List<String> mixedContent = new ArrayList<>();
		var mixedContent = new ArrayList<>();
		mixedContent.add("Strange with var");
		mixedContent.add(42);
		System.out.println("mixedContent: " + mixedContent.getClass());
	}
}
