package de.kiltz.kunden.server;

import de.kiltz.kunden.server.service.KundenVerwaltung;
import de.kiltz.kunden.server.service.KundenVerwaltungDummyImpl;

public class ServiceLocator {

    public static KundenVerwaltung getKundenVerwaltung() {
        return new KundenVerwaltungDummyImpl();
    }

}
