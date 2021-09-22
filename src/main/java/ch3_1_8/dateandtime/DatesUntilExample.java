package ch3_1_8.dateandtime;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.stream.Stream;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017, 2020 by Michael Inden 
 */
public class DatesUntilExample
{
    public static void main(final String[] args)
    {
        final LocalDate myBirthday = LocalDate.of(1971, Month.FEBRUARY, 7);
        final LocalDate christmas = LocalDate.of(1971, Month.DECEMBER, 24);

        System.out.println("Day-Stream");
        final Stream<LocalDate> daysUntil = myBirthday.datesUntil(christmas);
        daysUntil.skip(150).limit(5).forEach(System.out::println);

        System.out.println("\nMonth-Stream");
        final Stream<LocalDate> monthsUntil = myBirthday.datesUntil(christmas, Period.ofMonths(1));
        monthsUntil.limit(3).forEach(System.out::println);
    }
}
