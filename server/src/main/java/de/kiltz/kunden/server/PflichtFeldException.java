package de.kiltz.kunden.server;

public class PflichtFeldException extends Exception {

    private static final long serialVersionUID = 1L;

    public PflichtFeldException(String meldung) {
        super(meldung);
    }
}
