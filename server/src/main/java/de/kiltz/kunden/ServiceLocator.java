package de.kiltz.kunden;

import de.kiltz.kunden.service.KundenVerwaltung;
import de.kiltz.kunden.service.KundenVerwaltungDummyImpl;

public class ServiceLocator {

    public static KundenVerwaltung getKundenVerwaltung() {
        return new KundenVerwaltungDummyImpl();
    }

}
