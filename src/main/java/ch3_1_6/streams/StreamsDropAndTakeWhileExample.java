package ch3_1_6.streams;

import static java.util.stream.Collectors.joining;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class StreamsDropAndTakeWhileExample 
{
    public static void main(final String[] args) {
    
        final IntStream stream1 = IntStream.iterate(1, n -> n + 1);
        System.out.println("takeWhile:   " + stream1.takeWhile(n -> n < 10).
                                                     mapToObj(Integer::toString).
                                                     collect(joining(", ")));
    
        final IntStream stream2 = IntStream.rangeClosed(7,  14);
        System.out.println("dropWhile 1: " + stream2.dropWhile(n -> n < 10).
    	                                     mapToObj(Integer::toString).
    	                                     collect(joining(", ")));
    
        final IntStream stream3 = IntStream.of(7,9,11,13,15,5,3,1);
        System.out.println("dropWhile 2: " + stream3.dropWhile(n -> n < 10).
                                             mapToObj(Integer::toString).
                                             collect(joining(", ")));
                
	    System.out.println();
	    
	    // Übungen
	    System.out.println("takeWhile:");
	    final Stream<String> values1 = Stream.of("a", "b", "c", "", "e", "f");
        values1.takeWhile(s -> !s.isEmpty())
               .forEach(System.out::println);
	    
	    System.out.println("\ndropWhile:");
	    final Stream<Integer> values2 = Stream.of(1, 2, 3, 11, 22, 33, 10);
        values2.dropWhile(value -> value < 10).
                forEach(System.out::println);
	}
}
