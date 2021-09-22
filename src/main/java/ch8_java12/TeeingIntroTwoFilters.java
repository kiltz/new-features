package ch8_java12;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.teeing;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class TeeingIntroTwoFilters
{
    public static void main(String[] args)
    {
        var names = Stream.of("Michael", "Tim", "Tom", "Mike", "Bernd", "Carsten");

        final Predicate<String> startsWithMI = text -> text.startsWith("Mi");
        final Predicate<String> endsWithM = text -> text.endsWith("m");

        final BiFunction<List<String>, List<String>, List<List<String>>> combineResults = (list1, list2) -> List
                        .of(list1, list2);

        var result = names.collect(teeing(filtering(startsWithMI, toList()), filtering(endsWithM, toList()),
                                          combineResults));

        System.out.println(result);
    }
}
