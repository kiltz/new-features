package de.kiltz.neu.in8;

import java.util.Arrays;
import java.util.List;

public class MethodenReferenz {
    public static void main(String[] args) {
        // Vergleich Lambda und Methodenreferenz

        final List<String> monate = Arrays.asList("Jan", "Feb", "Mär", "Apr"); // etc.

        System.out.println("Lambda");
        monate.forEach(monat -> System.out.println(monat));

        System.out.println("Methodenreferenz");
        monate.forEach(System.out::println);
    }
}
