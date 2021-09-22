package ch3_1_8.dateandtime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class LocalDateConversionExample
{
    public static void main(final String[] args)
    {
        final LocalDate someday = LocalDate.of(1971, 2, 7);
        final LocalTime time = LocalTime.of(2, 15);
        final Instant instant = Instant.ofEpochMilli(0);

        System.out.println("toEpochSecond: " + someday.toEpochSecond(time, ZoneOffset.ofHours(-5)));

        System.out.println("ofInstant: " + LocalDate.ofInstant(instant, ZoneId.of("Europe/Zurich")));
    }
}
