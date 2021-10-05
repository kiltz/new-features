package de.kiltz.neu.in8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Locale;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {
//        dasRunnable();
//        undAction();
//        sortiere();
        eigenesInterface();
    }

    private static void eigenesInterface() {
        MeinFuncInterface f = (a, b) -> a - b;
        int ergebnis = f.tuWas(7, 3);
        System.out.println("eigenesInterface 1: " + ergebnis);
        System.out.println("eigenesInterface 2: " + f.addiere(2, 5));
            // String wandleUm(String s);
        StringUmwandler u = String::toUpperCase;
        System.out.println(u.wandleUm("ganz kleiner Test"));
        System.out.println(u.wandleInKleinbuchstabenUm("ganz kleiner Test"));

        Function<String, Integer> f2 = s -> s.length();
        System.out.println(f2.apply("mein Text"));

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
            public void actionPerformed(ActionEvent event){
                machWasGanzWichtiges(event);
            }
        });

        // Lamda lang
        button.addActionListener((ActionEvent event) -> {
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
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Der Inhalt der run-Methode. (1)");
            }
        };
        r2.run();

        Runnable r = () -> System.out.println("Der Inhalt der run-Methode. (2)");

        r.run();
    }
}
