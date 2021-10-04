package de.kiltz.neu.in8.aufgabe;

import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        List<Kunde> kundenListe = erzeugeListe();
        // Pädikate definieren
        // filtern
        kundenListe.removeIf(BAPredicate.nullOrEmpty());
        // ausgeben
        kundenListe.forEach(System.out::println);

    }

    private static List<Kunde> erzeugeListe() {
        List<Kunde> liste = new ArrayList<>();
        // füllen
        liste.add(new Kunde());
        liste.add(new Kunde("NN", "VN"));
        return liste;

    }
}
