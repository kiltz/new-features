package ch4_java10;

import static java.util.stream.Collectors.toUnmodifiableList;
import static java.util.stream.Collectors.toUnmodifiableMap;
import static java.util.stream.Collectors.toUnmodifiableSet;

import java.util.List;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class ImmutableCollectionsExample
{
    public static void main(final String[] args)
    {
        var names = List.of("Tim", "Tom", "Mike", "Peter", "Tom", "Tim");
        
        var immutableNames = names.stream().collect(toUnmodifiableList());
        System.out.println("immutableNames type: " + immutableNames.getClass());
        
        var uniqueImmutableNames = names.stream().collect(toUnmodifiableSet());
        System.out.println("uniqueImmutableNames content: " + uniqueImmutableNames);
        System.out.println("uniqueImmutableNames type: " + uniqueImmutableNames.getClass());
        
           
         var nameCount = names.stream().                                
                               collect(toUnmodifiableMap(key -> key, 
                                                         value -> 1L, 
                                                         (count, inc) -> count + inc));  
         System.out.println("content: " + nameCount);
         System.out.println("type:    " + nameCount.getClass());
    }
}
