package de.kiltz.neu.in8;

import java.util.*;
import java.util.function.Supplier;

public class DasOptionale {
    public static void main(String[] args) {
        erzeugen();
        behandeln();
        primitiveDatenTypen();
    }

    private static void primitiveDatenTypen() {
        final int[] sampleValues = {1,3,5,7,11,13,17,19};
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
        System.out.println(min.orElse( 1));
        // Berechne Ersatzwert, wenn nicht vorhanden
        final Supplier<Integer> randomGenerator = () -> (int)(100 * Math.random());
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
        final Optional<Integer> min =Arrays.stream(noValues).min(naturalOrder);

        System.out.println("max: " + max);
        System.out.println("min: " + min);

        // Prüfe, ob es einen Wert gibt
        System.out.println("isPresent?: " + min.isPresent());
        // Zugriff auf den Wert
        final Integer maxValue = max.get();
        System.out.println ("maxValue: " + maxValue);

        // Konstruktionsmethoden
        final Optional<Integer> optionalFromValue = Optional.of(4711);
        final Optional<Double> optionalFromNull = Optional.ofNullable(null);
        System.out.println("from Value: " + optionalFromValue);
        System.out.println("from null: " + optionalFromNull);
    }
}
