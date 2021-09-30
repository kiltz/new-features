package de.kiltz.neu.in9.property;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Ein einfaches "änderbares" Modell.
 */
public class Counter {
    //	Die Daten
    private int anzahl;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public Counter(int anzahl) {
        this.anzahl = anzahl;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void increment() {
        anzahl++;
        support.firePropertyChange("Increment", anzahl - 1, anzahl);
    }

    public void decrement() {
        anzahl--;
        support.firePropertyChange("Decrement", anzahl + 1, anzahl);
    }

}