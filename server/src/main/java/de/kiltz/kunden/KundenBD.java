package de.kiltz.kunden;

import java.util.List;

import de.kiltz.kunden.dto.Kunde;
import de.kiltz.kunden.service.KundenVerwaltung;
import de.kiltz.kunden.service.PflichtFeldException;

public class KundenBD {

    private final KundenVerwaltung service;

    public KundenBD() {
        service = ServiceLocator.getKundenVerwaltung();
    }

    public List<Kunde> suche(String s) {
        // Delegiere zum EJB-Service
        return service.suche(s);
    }

    public Kunde neuerKunde(Kunde k) throws PflichtFeldException {
        return service.neuerKunde(k);
    }

    public Kunde holePerId(Long id) {

        return service.getKundeByID(id);
    }
}
