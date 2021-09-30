package de.kiltz.neu.in9.property;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Das Benutzerinterface, das Veränderugnen verursacht und auch Nachricht über
 * Veränderungen erhält (s. Methode update).
 */
public class CounterView {
    private JFrame frame;
    private JTextField tf;
    //	Das änderbare Modell
    private Counter counter;

    public CounterView(String title, Counter c) {
        frame = new JFrame(title);
        counter = c;
        init();
    }

    private void init() {
        JPanel tfPanel = new JPanel();
        tf = new JTextField(10);
        tf.setText(counter.getAnzahl() + "");
        tfPanel.add(tf);
        frame.add("North", tfPanel);
        JPanel buttonPanel = new JPanel();
        // herunterzählen
        JButton incButton = new JButton("Increment");
        incButton.addActionListener(e -> increment());
        buttonPanel.add(incButton);
        // hochzählen
        JButton decButton = new JButton("Decrement");
        decButton.addActionListener(e -> decrement());
        buttonPanel.add(decButton);
        // Ende-Button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        buttonPanel.add(exitButton);
        frame.add("South", buttonPanel);

        counter.addPropertyChangeListener(e -> {
            tf.setText(counter.getAnzahl() + "");
            System.out.println(
                    "Prop: " + e.getPropertyName() + "  old: " + e.getOldValue() + "  new: " + e.getNewValue());

        });

        // Beenden beim Klick aufs Kreuz
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);

    }

    protected void decrement() {
        counter.decrement();
        tf.setText(counter.getAnzahl() + "");
    }

    protected void increment() {
        counter.increment();
        tf.setText(counter.getAnzahl() + "");

    }

}