package appendix.dateandtime;

import java.time.Duration;
import java.time.Instant;

/**
 * Beispielprogramm zur Demonstration der Klasse Duration.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2020 by Michael Inden 
 */
public class DurationExample
{
    public static void main(final String[] args)
    {
        // Erzeugung  
    	final Duration durationFromNanos = Duration.ofNanos(7);
        final Duration durationFromSecs = Duration.ofSeconds(15);
        final Duration durationFromMinutes = Duration.ofMinutes(30);
        final Duration durationFromHours = Duration.ofHours(45);
        final Duration durationFromDays = Duration.ofDays(60);

        System.out.println("From Nanos:   " + durationFromNanos);
        System.out.println("From Secs:    " + durationFromSecs);
        System.out.println("From Minutes: " + durationFromMinutes);
        System.out.println("From Hours:   " + durationFromHours);
        System.out.println("From Days:    " + durationFromDays);

        // Berechnungen 
        final Instant now = Instant.now();
        final Instant silvester2013 = Instant.parse("2013-12-31T00:00:00Z");
        final Instant myBirthday2025 = Instant.parse("2025-02-07T00:00:00Z");
        final Duration duration1 = Duration.between(now, silvester2013);
        final Duration duration2 = Duration.between(now, myBirthday2025);

        System.out.println(now + " -- " + silvester2013 + ": " + duration1);
        System.out.println(now + " -- " + myBirthday2025 + ": " + duration2);
    }
}