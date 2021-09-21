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
package de.kiltz.neu.in8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatumUtils {

    public static final int IDX_TAGE = 3;
    public static final int IDX_STUNDEN = 2;
    public static final int IDX_MINUTEN = 1;
    public static final int IDX_SEKUNDEN = 0;


    /**
     * Berechnet Tage, Stunden, Minuten und Sekunden
     *
     * @param start als LocalDateTime
     * @param ende als LocalDateTime
     * @return ein 2 (nur Minuten und Sekunden) oder 4-Stelliges (bei Tagen > 0) long-Array
     */
    public static long[] getDiff(LocalDateTime start, LocalDateTime ende) {
        long[] zeiten = null;

        Duration diff = Duration.between(start, ende);
        if (diff.toDays() > 0) {
            zeiten = new long[IDX_TAGE + 1];
            zeiten[IDX_TAGE] = diff.toDays();
            diff = diff.minusDays(zeiten[IDX_TAGE]);
        }
        if (diff.toHours() > 0) {
            if (zeiten == null) {
                zeiten = new long[IDX_STUNDEN + 1];
            }
            zeiten[IDX_STUNDEN] = diff.toHours();
            diff = diff.minusHours(zeiten[IDX_STUNDEN]);
        }
        if (zeiten == null) {
            zeiten = new long[IDX_MINUTEN + 1];
        }
        zeiten[IDX_MINUTEN] = diff.toMinutes();
        diff = diff.minusMinutes(zeiten[IDX_MINUTEN]);
        zeiten[IDX_SEKUNDEN] = diff.getSeconds();
        return zeiten;
    }

    /**
     *
     */
    private DatumUtils() {
    }

    public static Object getDiffAlsText(LocalDateTime start, LocalDateTime ende) {
        StringBuilder txt = new StringBuilder();
        long[] diffs = DatumUtils.getDiff(start, ende);
        if (diffs.length > DatumUtils.IDX_TAGE) {
            txt.append(String.format("%d Tage ", diffs[DatumUtils.IDX_TAGE]));
        }
        if (diffs.length > DatumUtils.IDX_STUNDEN) {
            txt.append(String.format("%d Std. ", diffs[DatumUtils.IDX_STUNDEN]));
        }
        txt.append(
                String.format("%d Min. und %d Sek. ", diffs[DatumUtils.IDX_MINUTEN], diffs[DatumUtils.IDX_SEKUNDEN]));
        return txt.toString();
    }

    /**
     *
     * @param value Das Datum in Form JJJJMMTT
     * @return gibt das aktuelle Datum zurück, wenn keins oder kein gültiges Datum übergeben wurde.
     */
    public static LocalDate toLocalDate(String value) {
        // 20150813
        LocalDate localDate = LocalDate.now();
        if (value != null) {
            try {
                localDate = LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyyMMdd"));

            } catch (DateTimeParseException e) {
                localDate = LocalDate.now();
            }
        }
        return localDate;
    }

    public static Date asDate(String datum) {
        LocalDate localDate = LocalDate.parse(datum, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return asDate(localDate);
    }

    public static Date asDate(LocalDate localDate) {

        return localDate == null ? null
                : Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date asDate(LocalDateTime localDateTime) {
        return localDateTime == null ? null : Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate asLocalDate(Date date) {
        return date == null ? null : Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime asLocalDateTime(Date date) {
        return date == null ? null
                : Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static LocalDate morgen() {
        LocalDate morgen = LocalDate.now().plusDays(1);
        return morgen;
    }

    public static String jetzt() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }

    public static String heute() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static Date machEndeDesTages(Date datum) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(datum);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return datum = cal.getTime();
    }

    public static LocalDateTime machEndeDesTages(LocalDateTime datum) {
        LocalTime lt = LocalTime.MAX;
        LocalDate ld = datum.toLocalDate();
        return LocalDateTime.of(ld, lt);
    }

    public static Date vorTagen(Integer tage) {
        LocalDate datum = LocalDate.now().minusDays(tage);
        return asDate(datum);
    }
}
