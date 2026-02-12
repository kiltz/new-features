package de.kiltz.neu.in10;

import java.util.Map;

public class AllgemeineNeuerungen {

    public static void main(String[] args) {
        // ab 10: var : Local Variable Type Inference
        var text = "Ein String";
        System.out.println(text.toUpperCase());

        // in 9
        final Map<Integer, String> map1 = Map.of(1, "Januar", 2, "Februar");
        // in 10 (fahre mit der Maus über var ...)
        final var map2 = Map.of(1, "Januar", 2, "Februar");

        // neu in 10: copyOf für List, Set und Map
        final var neqInmutableCopy = Map.copyOf(map1);
        System.out.println(neqInmutableCopy.getClass()); // java.util.ImmutableCollections$MapN


    }
}
