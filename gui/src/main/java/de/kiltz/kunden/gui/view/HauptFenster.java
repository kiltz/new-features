package de.kiltz.kunden.gui.view;

import de.kiltz.kunden.gui.controller.NeuController;
import de.kiltz.kunden.gui.controller.SucheController;
import de.kiltz.kunden.gui.utils.GUITools;
import de.kiltz.kunden.server.dto.Kunde;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HauptFenster {

    private JFrame frame;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public HauptFenster() {
        init();
    }

    private void init() {
        frame = new JFrame("Kundenverwaltung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setJMenuBar(getJMenuBar());

        GUITools.zentriere(frame);
        frame.setVisible(true);

    }

    private JMenuBar getJMenuBar() {
        JMenuBar bar = new JMenuBar();
        JMenu datei = new JMenu("Datei");
        datei.setMnemonic('d');
        JMenuItem ende = new JMenuItem("Beenden");
        ende.addActionListener(e -> System.exit(0));
        datei.add(ende);

        JMenu kunden = new JMenu("Kunden");
        kunden.setMnemonic('k');
        JMenuItem suche = new JMenuItem("Suchen");
        suche.addActionListener(e -> zeigSuche());
        kunden.add(suche);
        JMenuItem neu = new JMenuItem("Neu");
        neu.addActionListener(e -> zeigNeu());
        kunden.add(neu);

        bar.add(datei);
        bar.add(kunden);
        return bar;
    }

    protected void zeigNeu() {
        NeuController.installController(this);

    }

    protected void zeigSuche() {
        new SucheController(this);

    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void notifyObservers(Kunde k) {

        support.firePropertyChange("neuer Kunde", null, k);
    }

    public JFrame getFrame() {
        return frame;
    }
}
