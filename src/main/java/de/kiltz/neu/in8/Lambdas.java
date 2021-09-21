package de.kiltz.neu.in8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Lambdas {
    public static void main(String[] args) {
        dasRunnable();
        undAction();
        sortiere();
        eigenesInterface();
    }

    private static void eigenesInterface() {
        MeinFuncInterface f = (a, b) -> a - b;
        int ergebnis = f.tuWas(7, 3);
        System.out.println("eigenesInterface 1: " + ergebnis);
        System.out.println("eigenesInterface 2: " + f.addiere(2, 5));

    }


    private static void sortiere() {
        String[] words = {"aaa", "b", "cc"};
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        // schöner mit Streams...kommt später ;-)
        for (String s : words) {
            System.out.println(s);
        }
    }

    private static void undAction() {
        JButton button = new JButton("tu was");
        // alt
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                machWasGanzWichtiges(event);
            }
        });
        // Lamda lang
        button.addActionListener((event) -> {
            machWasGanzWichtiges(event);
        });
        // Lamda kurz  ohne Methodereferenz
        button.addActionListener((event) -> machWasGanzWichtiges(event));
        // da nur ein Paramter vorhanden ist, kann die Klammer weg gelassen werden
        button.addActionListener(event -> machWasGanzWichtiges(event));
        // mit Methoden-Referenz (::)
        button.addActionListener(Lambdas::machWasGanzWichtiges);

    }

    private static void machWasGanzWichtiges(ActionEvent event) {
        System.out.println("Klick!");
    }

    private static void dasRunnable() {
        Runnable r = () -> System.out.println("Der Inhalt der run-Methode.");
        r.run();
    }
}
