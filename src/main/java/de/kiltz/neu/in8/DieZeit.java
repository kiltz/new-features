package de.kiltz.neu.in8;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class DieZeit {
    public static void main(String[] args) {
        instant();


    }

    private static void instant() {
        Instant einInstant = Instant.parse("2021-09-16T12:30:00Z");
        Instant zweiTageSpaeter = einInstant.plus(2, ChronoUnit.DAYS);
    }
}
