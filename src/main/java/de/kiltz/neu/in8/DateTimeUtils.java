package de.kiltz.neu.in8;

import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Timestamp;
import java.time.*;
import java.util.Date;

public final class DateTimeUtils {
    public static final ZoneId TIME_ZONE = ZoneId.of("Europe/Berlin");
    public static final ZoneId UTC_TIME_ZONE = ZoneId.of("UTC");

    public static final String DATETIME_PATTERNS_DESCRIPTION = "yyyy-MM-dd'T'HH:mm:ss, yyyy-MM-dd'T'HH:mm, yyyyMMddHHmmss, yyyyMMddHHmm, HH:mm:ss dd.MM.yyyy, HH:mm dd.MM.yyyy, dd.MM.yyyy HH:mm:ss, dd.MM.yyyy HH:mm";
    private static final String[] DATETIME_PATTERNS = DATETIME_PATTERNS_DESCRIPTION.split(", ");

    public static final String DATE_PATTERNS_DESCRIPTION = "yyyy-MM-dd, yyyyMMdd, dd.MM.yyyy";
    private static final String[] DATE_PATTERNS = DATE_PATTERNS_DESCRIPTION.split(", ");


    private DateTimeUtils() {
        // invisible
    }


    /**
     * Erzeugt ein {@link Date} aus einem XML-Zeitstempel.
     *
     */
    public static Date toDate(XMLGregorianCalendar calendar) {
        return calendar == null ? null : calendar.toGregorianCalendar().getTime();
    }

    public static Date toDate(LocalDateTime val) {
        return Date.from(val.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date toDate(LocalDate val) {
        return Date.from(val.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Timestamp toTimestamp(LocalDateTime val) {
        if (val == null) {
            return null;
        }
        return Timestamp.valueOf(val);
    }

    public static Timestamp toTimestamp(LocalDate val) {
        if (val == null) {
            return null;
        }
        return Timestamp.valueOf(val.atStartOfDay());
    }

    /**
     * Erzeugt ein {@link LocalDate} aus einem XML-Zeitstempel.
     */
    public static LocalDate toLocalDate(XMLGregorianCalendar calendar) {
        return calendar == null ? null : toZonedDateTime(calendar).toLocalDate();
    }

    public static LocalDate toLocalDate(Timestamp val) {
        if (val == null) {
            return null;
        }
        return val.toLocalDateTime().toLocalDate();
    }

    public static LocalDate toLocalDate(Date val) {
        return val.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDate toLocalDate(long millis) {
        return LocalDate.ofInstant(Instant.ofEpochMilli(millis), ZoneId.systemDefault());
    }


    public static LocalDateTime toLocalDateTime(Date val) {
        return val.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static LocalDateTime toLocalDateTime(long millis) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.systemDefault());
    }

    /**
     * Erzeugt ein {@link LocalDateTime} aus einem XML-Zeitstempel.
     */
    public static LocalDateTime toLocalDateTime(XMLGregorianCalendar calendar) {
        return calendar == null ? null : toZonedDateTime(calendar).toLocalDateTime();
    }

    public static LocalDateTime toLocalDateTime(Timestamp val) {
        if (val == null) {
            return null;
        }
        return val.toLocalDateTime();
    }

    /**
     * Erzeugt ein {@link ZonedDateTime} aus einem XML-Zeitstempel.
     */
    public static ZonedDateTime toZonedDateTime(XMLGregorianCalendar calendar) {
        return calendar == null ? null : calendar.toGregorianCalendar().toZonedDateTime();
    }

    public static ZonedDateTime toZonedDateTime(long millis, ZoneId zoneId) {
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(millis), zoneId);
    }

}
 
