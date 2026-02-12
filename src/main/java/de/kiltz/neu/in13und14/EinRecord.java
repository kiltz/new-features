package de.kiltz.neu.in13und14;

public record EinRecord(String vorname, String nachname, int alter) {
    public String name() {
        return vorname + " " + nachname;
    }

}
