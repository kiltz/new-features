package de.kiltz.neu.in8;

import java.util.Locale;

@FunctionalInterface
public interface StringUmwandler {

    String wandleUm(String s);
    default String wandleInKleinbuchstabenUm(String s) {
        return s.toLowerCase();
    }
}
