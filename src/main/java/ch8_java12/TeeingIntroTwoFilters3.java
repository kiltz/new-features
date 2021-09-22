package ch8_java12;

import static java.util.stream.Collectors.*;

import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class TeeingIntroTwoFilters3
{
    public static void main(String[] args)
    {
        var inputNames = Stream.of("Michael", "Tim", "Tom", "Mike", "Bernd");
        // "Tim", "Mike", "Tom", "Tom");

        final Predicate<String> startsWithMi = text -> text.startsWith("Mi");

        final Predicate<String> isShort = text -> text.length() <= 4;

        BiFunction combineResults = (a, b) -> {
            System.out.println(a + " / " + b);
            return a;
        };

        var result = inputNames.collect(teeing(
                                               // JDK 9: filtering()-Kollektor, Problematsisch für Duplikate
                                               Collectors.toMap(str -> str, String::length),
                                               Collectors.groupingBy(str -> str, counting()), combineResults));

        System.out.println(result);
    }
}
