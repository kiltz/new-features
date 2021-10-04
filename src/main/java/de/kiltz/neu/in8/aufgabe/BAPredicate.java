package de.kiltz.neu.in8.aufgabe;

import java.util.function.Predicate;

public class BAPredicate {

    private static Predicate<String> nullOrEmptyString() {
        return new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s == null || s.isEmpty();
            }
        };
    }

    public static Predicate<Kunde> nullOrEmpty() {
        return new Predicate<Kunde>() {
            @Override
            public boolean test(Kunde k) {

                return k == null || (nullOrEmptyString().test(k.getName())
                        && nullOrEmptyString().test(k.getVorname()));
            }
        };
    }
}
