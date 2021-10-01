package de.kiltz.neu.in8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Date;

public class DieZeit {
    public static void main(String[] args) {
        instant();
        basics();
        zeitraeume();
        umwandlung();
    }

    private static void umwandlung() {
        // zu Date
        LocalDate localDate = LocalDate.now();
        Date d = Date.from(localDate.atStartOfDay()
                .atZone(ZoneId.systemDefault()).toInstant());

        LocalDateTime localDateTime = LocalDateTime.now();
        d = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        // von Date
        Date date = new Date();
        LocalDate ld = Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDateTime ldt = Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    private static void zeitraeume() {
        LocalDate firstDate = LocalDate.of(2010, 5, 17); // 2010-05-17
        LocalDate secondDate = LocalDate.of(2015, 3, 7); // 2015-03-07
        Period period = Period.between(firstDate, secondDate);
        int days = period.getDays(); // 18
        int months = period.getMonths(); // 9
        int years = period.getYears(); // 4
        boolean isNegative = period.isNegative(); // false
        // Duration ergibt die Zeitdauer
        LocalDateTime start = LocalDateTime.of(2021, 9, 30, 12, 0);
        LocalDateTime ende = LocalDateTime.now();
        Duration diff = Duration.between(start, ende);
        System.out.println(diff); // z.B. PT26H55M8.1282557S (ISO 8601, PT=PeriodTime)
        System.out.println(diff.getSeconds());

        Period twoMonths_TenDays = Period.ofMonths(2).withDays(10);
        System.out.println(twoMonths_TenDays); //P2M10D
    }

    private static void basics() {
        // Erzeugen //
        // jetzt
        LocalDate heute = LocalDate.now();
        // Vorgabe über Zahlen:
        LocalDate weihnachten = LocalDate.of(2019, 12, 24);
        // der 45 Tag des Jahres 2019
        LocalDate der45te = LocalDate.ofYearDay(2019, 45);

        // Veränderungen
        LocalDate morgen = LocalDate.now().plusDays(1);
        LocalDateTime dateTime =
                LocalDateTime.now().minusHours(5).minusMinutes(30);
        LocalDate ersterTagDesMonats =
                LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalDate letzterTagDesMonats =
                LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());

        // Ausgaben
        Month monat = heute.getMonth();
        int year = heute.getYear();
        String datumAlsText = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        datumAlsText = LocalDate.now().format(DateTimeFormatter.ISO_DATE);

    }

    private static void instant() {
        Instant einInstant = Instant.parse("2021-09-16T12:30:00Z");
        Instant zweiTageSpaeter = einInstant.plus(2, ChronoUnit.DAYS);
    }
}
