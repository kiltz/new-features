package de.kiltz.neu.in8.aufgabe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Kunde {
    private String name;
    private String vorname;
    private Adresse adresse;
    private List<String> telefonnummern;



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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<String> getTelefonnummern() {
        telefonnummern = Optional.ofNullable(telefonnummern).orElse(new ArrayList<String>());
        return telefonnummern;
    }

    public void setTelefonnummern(List<String> telefonnummern) {
        this.telefonnummern = telefonnummern;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "name='" + name + '\'' +
                ", vorname='" + vorname + '\'' +
                ", adresse=" + adresse +
                ", telefonnummern=" + telefonnummern +
                '}';
    }
}
