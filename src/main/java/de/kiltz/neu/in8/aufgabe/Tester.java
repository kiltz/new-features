package de.kiltz.neu.in8.aufgabe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Tester {
    public static void main(String[] args) {
        List<Kunde> kundenListe = erzeugeListe();
        // Pädikate definieren
        // filtern
        kundenListe.removeIf(BAPredicate.nullOrEmpty());
        // ausgeben
        kundenListe.forEach(System.out::println);
        suche();

    }

    private static void suche() {
        List<Kunde> kundenListe = erzeugeListe();
        kundenListe.stream()
                .flatMap(kunde -> kunde.getTelefonnummern().stream())
                .forEach(System.out::println);

        kundenListe.stream()
                .filter(k -> Optional.ofNullable(k.getAdresse()).isPresent())
                .filter(k -> k.getAdresse().getStrasse().startsWith("Haupt"))
                .forEach(System.out::println);
    }

    private static List<Kunde> erzeugeListe() {
        List<Kunde> liste = new ArrayList<>();
        // füllen
        liste.add(new Kunde());
        liste.add(new Kunde("NN", "VN"));
        Kunde k = new Kunde("NN2", "VN2");
        k.setAdresse(new Adresse("Hauptstrasse 2", "50858", "Köln"));
        k.getTelefonnummern().add("0123-854795");
        k.getTelefonnummern().add("02234-9203-270");
        liste.add(k);
        k = new Kunde("NN3", "VN3");
        k.setAdresse(new Adresse("Hauptstrasse 4", "90443", "Nürnberg"));
        k.getTelefonnummern().add("0123-854796");
        k.getTelefonnummern().add("0911-9203-270");
        liste.add(k);
        k = new Kunde("NN4", "VN4");
        k.setAdresse(new Adresse("Lindenstrasse 4", "90443", "Nürnberg"));
        k.getTelefonnummern().add("0123-854796");
        k.getTelefonnummern().add("0911-9203-270");
        liste.add(k);

        return liste;

    }
}
