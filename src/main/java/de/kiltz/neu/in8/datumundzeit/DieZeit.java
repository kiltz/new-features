/*
 * Dieses Programm ist KONSENS-Software und urheberrechtlich geschützt.
 * Nutzungsrechte werden nach KONSENS-Gesetz § 27 Nutzungsrecht und
 * Verwaltungsabkommen KONSENS Abschnitt 11 Nutzungsrecht  eingeräumt.
 *
 * Eine Kopie der Lizenz erhalten Sie unter:
 *
 * https://www.gesetze-im-internet.de/konsens-g/BJNR312900017.html
 * http://archiv.konsens.ktz.testa-de.net/Zentraldokumente/VerwAbk_KONSENS/
 */
package de.kiltz.neu.in8.datumundzeit;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DieZeit {
    public static void main(String[] args) {
        // instant();
        // basics();
        einParse();
        // zeitraeume();
        // umwandlung();
    }

    private static void einParse() {
        String eingabe = "01.09.2022";
        LocalDate ld = LocalDate.parse(eingabe, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println(ld);
    }

    private static void umwandlung() {
        // zu Date
        LocalDate localDate = LocalDate.now();
        Date d = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(d);
        LocalDateTime localDateTime = LocalDateTime.now();
        d = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(d);
        // von Date
        Date date = new Date();
        LocalDate ld = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(ld);
        LocalDateTime ldt = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(ldt);
    }

    private static void zeitraeume() {
        LocalDate firstDate = LocalDate.of(2010, 5, 17); // 2010-05-17
        LocalDate secondDate = LocalDate.of(2015, 3, 7); // 2015-03-07
        Period period = Period.between(firstDate, secondDate);
        int days = period.getDays(); // 18
        int months = period.getMonths(); // 9
        int years = period.getYears(); // 4
        boolean isNegative = period.isNegative(); // false
        System.out.println(days + "/" + months + "/" + years + "/" + isNegative);
        // Duration ergibt die Zeitdauer
        LocalDateTime start = LocalDateTime.of(2021, 9, 30, 12, 0);
        LocalDateTime ende = LocalDateTime.now();
        Duration diff = Duration.between(start, ende);
        System.out.println(diff); // z.B. PT26H55M8.1282557S (ISO 8601, PT=PeriodTime)
        System.out.println(diff.getSeconds());

        Period twoMonths_TenDays = Period.ofMonths(2).withDays(10);
        System.out.println(twoMonths_TenDays); // P2M10D
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
        LocalDateTime dateTime = LocalDateTime.now().minusHours(5).minusMinutes(30);
        LocalDate ersterTagDesMonats = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalDate letzterTagDesMonats = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());

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
