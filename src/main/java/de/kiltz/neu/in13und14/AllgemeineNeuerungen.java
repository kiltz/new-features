package de.kiltz.neu.in13und14;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class AllgemeineNeuerungen {
    private String nada;

    public static void main(String[] args) {
        switchExpression();
        verbesserteNullPointerEx();
        textBloecke();
        records();
        geschicktesInstanceOf();
    }

    private static void geschicktesInstanceOf() {
        Object o = "Ein String";
        // damals
        if (o instanceof String) {
            String s = (String) o;
            System.out.println(s.toUpperCase());
        }
        // heute oder morgen
        if (o instanceof String s) {
            System.out.println(s.toLowerCase());
        }
        // auch im if verfügbar:
        if (o instanceof String s && s.length() > 5) {
            System.out.println(s.length());
        }



    }

    private static void records() {
        EinRecord rec = new EinRecord("VN", "NN", 18);
        EinRecord rec2 = new EinRecord("VN", "NN", 18);
        System.out.println(rec.nachname());
        System.out.println(rec.name());
        System.out.println(rec.equals(rec2));
        System.out.println(rec);
        // kein Setter, unveränderlich (sofern die Inhalte unveränderlich sind)
    }

    private static void textBloecke() {
        System.out.println("*".repeat(20));
        System.out.println("""
                -Ich bin ein-
                -Text Block-
                    eine Einrückung
                """);
        System.out.println("*".repeat(20));
        System.out.println("""
                First 'line' simple quotes
                Second "line" double quotes
                Third line \""" three quotes
                Fourth line no quotes, just \\ :-)""");
        System.out.println("*".repeat(20));
        System.out.println("""
                Ein %s und \
                heute ist der "%tF"
                der Backslash zieht die Zeilen zusammen
                """.formatted("Parameter", LocalDate.now()));

        // Cool für XML, JSON, SQL etc...
    }

    private static void verbesserteNullPointerEx() {
        try {
            AllgemeineNeuerungen a = null;
            a.nada = "Geht nicht"; // => Cannot assign field "nada" because "a" is null
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void switchExpression() {
        DayOfWeek day = DayOfWeek.FRIDAY;
        int numOfLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
        };
        System.out.println(numOfLetters);
    }
}
