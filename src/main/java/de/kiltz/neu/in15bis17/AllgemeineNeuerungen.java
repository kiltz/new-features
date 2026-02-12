package de.kiltz.neu.in15bis17;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllgemeineNeuerungen {
    public static void main(String[] args) throws ParseException {
        neuesBeiString();
        ausCollectWirdToList();
        kompakteNummern();
    }

    private static void kompakteNummern() throws ParseException {
        var shortFormat = getCompactNumberFormat(NumberFormat.Style.SHORT);
        formatNumbers("SHORT", shortFormat);
        var longFormat = getCompactNumberFormat(NumberFormat.Style.LONG);
        formatNumbers("LONG", longFormat);
        // zurück geht es mit parse
        System.out.println("Parse: "+longFormat.parse("1 Million"));
        System.out.println(shortFormat.parse("1\u00a0Mio.")); // non-breakable Space
    }

    private static void ausCollectWirdToList() {
        // früher
        List<String> namesMi = Stream.of("Tim", "Tom", "Mike", "Michael").
                filter(str -> str.startsWith("Mi")).
                collect(Collectors.toList());
        // ab Java 16
        namesMi = Stream.of("Tim", "Tom", "Mike", "Michael").
                filter(str -> str.startsWith("Mi")).
                toList();
    }

    private static NumberFormat getCompactNumberFormat(NumberFormat.Style style)
    {
        return NumberFormat.getCompactNumberInstance(Locale.GERMAN, style);
    }
    private static void formatNumbers(final String style,
            final NumberFormat numberFormat)
    {
        System.out.println("\nNumberFormat " + style);
        System.out.println(numberFormat.format(10_000));
        System.out.println(numberFormat.format(123_456));
        System.out.println(numberFormat.format(1_234_567));
        System.out.println(numberFormat.format(2_234_567));
        System.out.println(numberFormat.format(1_950_000_000));
    }

    private static void neuesBeiString() {
        String msg = "%d mal %d ist %d";
        // früher
        System.out.println(String.format(msg, 2, 3, 6));
        // ab Java 15
        System.out.println(msg.formatted(2, 3, 6));

        var einString = "Eins  Zwei " + msg;
        System.out.println(einString);
    }

}
/*

Tipp: Performance von formatted() und format()
Der allseits geschätzte Java-Experte Dr. Heinz Kabutz hat sich ausgiebig u. a. mit
Strings und der Performance verschiedener Operationen, insbesondere Konkatenationen,
beschäftigt. In seinem Beitrag im Java Magazin 5/2022 zeigt er auf, dass
mit Java 17 die Methode String.format() und damit ebenfalls die Methode
String.formatted() um den Faktor 3 schneller geworden ist. Interessant ist
auch, dass das einfache + seit Java 9 in der Regel die schnellste Variante zum
Verknüpfen von Strings ist – von einigen Besonderheiten in Schleifen einmal abgesehen.
Generell betont er, so lesbar wie möglich zu programmieren und dass dies
oftmals mit String.format() oder String.formatted() am besten gelingt.

 */