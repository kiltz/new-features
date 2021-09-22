package appendix.dateandtime;

import java.time.LocalDateTime;
import java.time.Period;

/**
 * Beispielprogramm zur Demonstration von Berechnungen mit der Klasse Period.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2015 by Michael Inden 
 */
public class PeriodCalculationExample
{
    public static void main(final String[] args)
    {
        final LocalDateTime start = LocalDateTime.of(1971, 2, 7, 10, 11);

        final Period thirtyOneDays = Period.ofDays(31);
        final Period fourWeeks = Period.ofWeeks(4);
        final Period oneMonth = Period.ofMonths(1);

        System.out.println("7.2.1971 + 31 Tage:  " + start.plus(thirtyOneDays));
        System.out.println("7.2.1971 + 4 Wochen: " + start.plus(fourWeeks));
        System.out.println("7.2.1971 + 1 Monat:  " + start.plus(oneMonth));
    }
}