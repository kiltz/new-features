package de.kiltz.kunden.gui.controller;

import de.kiltz.kunden.server.KundenBD;
import de.kiltz.kunden.server.dto.Kunde;
import de.kiltz.kunden.server.PflichtFeldException;
import de.kiltz.kunden.gui.model.NeuModel;
import de.kiltz.kunden.gui.view.HauptFenster;
import de.kiltz.kunden.gui.view.NeuView;

/**
 * Der Controller als Singleton
 *
 * @author tz
 */
public class NeuController {

    private static NeuController instance;
    private static HauptFenster hauptFenster;
    private final NeuModel neuModel;
    private final NeuView neuView;
    private final KundenBD bd;

    private NeuController() {
        neuModel = new NeuModel(this);
        neuView = new NeuView(hauptFenster, this, neuModel);
        neuModel.setView(neuView);
        bd = new KundenBD();
    }

    public synchronized static NeuController installController(HauptFenster fenster) {
        if (instance == null) {
            hauptFenster = fenster;
            System.out.println("Erzeuge neuen NeuController");
            instance = new NeuController();
        } else {
            if (instance.neuView != null) {
                instance.neuView.pruefeView();
            }
        }
        return instance;
    }

    public void speichern() {
        Kunde k = new Kunde(neuModel.getName(), neuModel.getKdNr());
        try {
            k = bd.neuerKunde(k);
            neuView.meldeOk(k.getId());
            hauptFenster.notifyObservers(k);
        } catch (PflichtFeldException e) {
            // Was tun mit der Ex? :(
            neuView.meldeFehler(e.getMessage());
        }
    }

}
