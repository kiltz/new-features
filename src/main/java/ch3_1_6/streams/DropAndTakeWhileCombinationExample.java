package ch3_1_6.streams;

import java.util.stream.Stream;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class DropAndTakeWhileCombinationExample
{
    public static void main(final String[] args)
    {
        Stream<String> words = Stream.of("ab", "bla", "<START>", 
                                         "Text", "zwischen", "den", "Start- ",
                                         "und", "Ende-Begrenzern",
                                         "<END>", "saas", "bla");
    
        Stream<String> content = words.dropWhile(word -> !word.equals("<START>"))
                                      .skip(1)
                                      .takeWhile(word -> !word.equals("<END>"));
    
        content.forEach(System.out::println);                           
    }
}
