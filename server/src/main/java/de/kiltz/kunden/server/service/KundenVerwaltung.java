package de.kiltz.kunden.server.service;

import java.util.List;

import de.kiltz.kunden.server.PflichtFeldException;
import de.kiltz.kunden.server.dto.Kunde;

public interface KundenVerwaltung {

    List<Kunde> suche(String s);

    Kunde neuerKunde(Kunde k) throws PflichtFeldException;

    Kunde getKundeByID(Long id);

}
