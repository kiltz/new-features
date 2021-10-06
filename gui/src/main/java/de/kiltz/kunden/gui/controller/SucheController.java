package de.kiltz.kunden.gui.controller;

import de.kiltz.kunden.gui.model.SucheModel;
import de.kiltz.kunden.gui.view.HauptFenster;
import de.kiltz.kunden.gui.view.SucheView;
import de.kiltz.kunden.server.KundenBD;
import de.kiltz.kunden.server.dto.Kunde;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.util.List;

public class SucheController {
    private final HauptFenster hauptFenster;
    private final SucheModel sucheModel;
    private final SucheView sucheView;
    private final KundenBD bd;
    private PropertyChangeListener listener;

    public SucheController(HauptFenster hauptFenster) {
        this.hauptFenster = hauptFenster;
        sucheModel = new SucheModel(this);
        sucheView = new SucheView(hauptFenster, this, sucheModel);
        sucheModel.setView(sucheView);
        bd = new KundenBD();
        addPropChange();
    }

    private void addPropChange() {
        listener = e -> suche();
        hauptFenster.addPropertyChangeListener(listener);
    }

    public void suche() {
        SwingUtilities.invokeLater(() -> {
            List<Kunde> liste = bd.suche(sucheModel.getSuchbegriff());
            sucheModel.setListe(liste);
            sucheView.aktualisiere();
        });
    }

    public void byeBye() {
        hauptFenster.removePropertyChangeListener(listener);

        System.out.println("nehme mich raus...");
    }

}
