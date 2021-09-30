package de.kiltz.neu.in8;

import java.util.*;
import java.util.function.Supplier;

public class DasOptionale {
    public static void main(String[] args) {
        erzeugen();
        behandeln();
        primitiveDatenTypen();
        mitLambdaUndMethodenReferenz();
        mappenUndFiltern();

    }

    private static void mappenUndFiltern() {
        String x = wuerfle() == 6 ? null : "abcdef";
        // Filtern: alt
        if (x != null && x.contains("ab")) {
            System.out.println(x);
        }
        // Filtern: neu
        var opt = Optional.ofNullable(x);
        opt.filter(str -> str.contains("ab")).ifPresent(System.out::println);

        // Mappen und filtern: alt
        if (x != null) {
            String str = x.toUpperCase();
            if (str.contains("AB")) {
                System.out.println(str);
            }
        }
        // Mappen und filtern: neu
        opt.map((String::toUpperCase)).
                filter(s -> s.contains("AB")).
                ifPresent(System.out::println);
    }

    private static int wuerfle() {
        int zahl = new Random().nextInt(6) + 1;
        System.out.println("Würfel: " + zahl);

        return zahl;
    }

    private static void mitLambdaUndMethodenReferenz() {
        Optional<String> da = Optional.of("Es ist da");
        Optional<String> nada = Optional.ofNullable(null);
        Optional<String> auchNada = Optional.empty();

        var obj = new DasOptionale();
        da.ifPresent(s -> obj.print(s));
        da.ifPresent(obj::print);
        nada.ifPresent(obj::print);
        auchNada.ifPresent(obj::print);

    }

    private void print(String s) {
        System.out.println("Print: " + s);
    }

    private static void primitiveDatenTypen() {
        final int[] sampleValues = {1, 3, 5, 7, 11, 13, 17, 19};
        // Berechnungen auf Streams mit primitiven Werten
        final OptionalInt min = Arrays.stream(sampleValues).min();
        final OptionalInt max = Arrays.stream(sampleValues).max();
        final OptionalDouble avg = Arrays.stream(sampleValues).average();
        System.out.println("min: " + min);
        System.out.println("max: " + max);
        System.out.println("avg: " + avg);
    }

    private static void behandeln() {
        final Integer[] noValues = {};
        final Optional<Integer> min = Arrays.stream(noValues).
                min(Comparator.naturalOrder());
        // Führe Aktion aus, wenn vorhanden
        min.ifPresent(System.out::println);
        // Alternativen Wert liefern, wenn nicht vorhanden
        System.out.println(min.orElse(1));
        // Berechne Ersatzwert, wenn nicht vorhanden
        final Supplier<Integer> randomGenerator = () -> (int) (100 * Math.random());
        System.out.println(min.orElseGet(randomGenerator));
        // Löse eine Exception aus, wenn nicht vorhanden
        //min.orElseThrow(() -> new NoSuchElementException("there is no minimum"));
    }

    private static void erzeugen() {
        final Integer[] sampleValues = {1, 3, 5, 7, 11, 13, 17, 19};
        final Integer[] noValues = {};
        // Minimum und Maximum berechnen und ausgeben
        final Comparator<Integer> naturalOrder = Comparator.naturalOrder();

        final Optional<Integer> max = Arrays.stream(sampleValues).max(naturalOrder);
        final Optional<Integer> min = Arrays.stream(noValues).min(naturalOrder);

        System.out.println("max: " + max);
        System.out.println("min: " + min);

        // Prüfe, ob es einen Wert gibt
        System.out.println("isPresent?: " + min.isPresent());
        // Zugriff auf den Wert
        final Integer maxValue = max.get();
        System.out.println("maxValue: " + maxValue);

        // Konstruktionsmethoden
        final Optional<Integer> optionalFromValue = Optional.of(4711);
        final Optional<Double> optionalFromNull = Optional.ofNullable(null);
        System.out.println("from Value: " + optionalFromValue);
        System.out.println("from null: " + optionalFromNull);
    }
}
