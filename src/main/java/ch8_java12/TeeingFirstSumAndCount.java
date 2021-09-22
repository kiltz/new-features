package ch8_java12;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class TeeingFirstSumAndCount
{
    public static void main(String[] args)
    {
        var firstSixNumbers = Stream.of(1, 2, 3, 4, 5, 6);
        System.out.println(calcCountAndSum(firstSixNumbers));

        var primeNumbers = Stream.of(1, 3, 5, 7, 11, 13, 17);
        System.out.println(calcCountAndSum(primeNumbers));

        // sinnvollere Varianten
        var primeNumbers2 = Stream.of(1, 3, 5, 7, 11, 13, 17);
        IntSummaryStatistics result = primeNumbers2.collect(Collectors.summarizingInt(i -> i));
        System.out.println(result);

        var primeNumbers3 = Stream.of(1, 3, 5, 7, 11, 13, 17).mapToInt(i -> i);
        System.out.println(primeNumbers3.summaryStatistics());
    }

    private static Pair<Long> calcCountAndSum(Stream<Integer> numbers)
    {

        return numbers.collect(Collectors.teeing(Collectors.counting(), Collectors.summingLong(n -> n),
                                                 Pair<Long>::new)); // (count, sum) -> new Pair<Long>(count, sum))
    }

    static class Pair<T>
    {
        public T first;

        public T second;

        public Pair(T first, T second)
        {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString()
        {
            return "Pair<T> [first=" + first + ", second=" + second + "]";
        }
    }
}
