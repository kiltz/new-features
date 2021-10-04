package de.kiltz.neu.in8.aufgabe;

public class Kunde {
    private String name;
    private String vorname;


    public Kunde(String name, String vorname) {
        this.name = name;
        this.vorname = vorname;
    }

    public Kunde() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "name='" + name + '\'' +
                ", vorname='" + vorname + '\'' +
                '}';
    }
}
