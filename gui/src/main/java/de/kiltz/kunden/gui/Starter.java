package de.kiltz.kunden.gui;

import javax.swing.SwingUtilities;

import de.kiltz.kunden.gui.view.HauptFenster;

public class Starter {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HauptFenster::new);
    }
}
