package ch4_java10;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class CopyOfExample
{
    public static void main(final String[] args)
    {       
        var names = List.of("Tim", "Tom", "Jerry");
        List<String> copyOfNames = List.copyOf(names); 
        System.out.println("copyOfList: " + copyOfNames.getClass());
        
        var colors = Set.of("Red", "Green", "Blue");
        Set<String> copyOfColors = Set.copyOf(colors);
        System.out.println("copyOfSet:  " + copyOfColors.getClass());
        
        var personAgeMapping = Map.of("Tim", 47L, "Tom", 12L, "Mike", 47L, "Max", 25L); 
        Map<String, Long> copyOfMap = Map.copyOf(personAgeMapping); 
        System.out.println("copyOfMap:  " + copyOfMap.getClass());
    }
}
