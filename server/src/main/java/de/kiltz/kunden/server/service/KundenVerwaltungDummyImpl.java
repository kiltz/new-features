package de.kiltz.kunden.server.service;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import de.kiltz.kunden.server.PflichtFeldException;
import de.kiltz.kunden.server.dto.Kunde;

/**
 * Klasse repräsentiert die BusinessEbene der Applikation.
 *
 * @author fk
 */
public class KundenVerwaltungDummyImpl implements KundenVerwaltung {

    private static List<Kunde> liste;

    public KundenVerwaltungDummyImpl() {
        if (liste == null) {
            erstelleTestDaten();
        }
    }

    private void erstelleTestDaten() {
        liste = new ArrayList<>();
        liste.add(new Kunde("Hägar", "K00001"));
        liste.add(new Kunde("Sven", "K00002"));
        liste.add(new Kunde("Helga", "K00003"));
        final Long[] i = {1L};
        liste.forEach(k -> k.setId(i[0]++));
    }

    @Override public List<Kunde> suche(String s) {
        return liste.stream()
                .filter(k -> k.getName().toLowerCase().contains(s.toLowerCase()))
                        .collect(Collectors.toList());
    }

    @Override public Kunde neuerKunde(Kunde k) throws PflichtFeldException {
        Optional.ofNullable(k.getName())
                .orElseThrow(() -> new PflichtFeldException("Name ist ein Pflichtfeld!"));

        Predicate<String> isNullOrEmpty = s -> s == null || s.isEmpty();
        if (isNullOrEmpty.test(k.getName())) {
            throw new PflichtFeldException("Name ist ein Pflichtfeld!");
        }

        liste.add(k);
        k.setId((long) liste.size());
        return k;
    }

    @Override public Kunde getKundeByID(Long id) {
        Kunde ret = null;
        if (id < liste.size()) {
            ret = liste.get(id.intValue());
        }
        return ret;
    }

}
