package de.kiltz.neu.in9;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SammlungFuer9 {
    public static void main(String[] args) {
        // Collection Factory
        final List<String> liste = List.of("Eins", "Zwei", "Drei");
        final Map<Integer, String> map = Map.of(1, "Januar", 2, "Februar");

        // Diamond Operator
        // in Java 8
        List<String> liste2 = new ArrayList<String>();
        // in Java 9
        List<String> liste3 = new ArrayList<>();


    }
}
