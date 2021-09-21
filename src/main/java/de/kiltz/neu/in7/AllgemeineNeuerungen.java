package de.kiltz.neu.in7;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Scanner;

public class AllgemeineNeuerungen {
    public static void main(String[] args) {
        unterstriche();
        stringsInSwitch();
        multiCatch();
        tryWithResource();

    }

    private static void tryWithResource() {
        InputStream in =
                ClassLoader.getSystemResourceAsStream(
                        "EastOfJava.txt");
        try ( Scanner res = new Scanner( in ) ) {
            System.out.println(
                    res.nextLine());
        }

        // eigenes Closeable
        try (EineRessource res = new EineRessource()) {
            res.tuWas();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }

    private static void multiCatch() {
        int[] zahlen = {12, 5, 6, 0, 45};

        try {
            int ergebnis = zahlen[5] / zahlen [3];

        } catch (ArrayIndexOutOfBoundsException | ArithmeticException exp) {
            System.out.println("Warning: Enter inputs as per instructions ");
        }
    }

    private static void stringsInSwitch() {
        //String input = javax.swing.JOptionPane.showInputDialog("Eingabe");
        String input = "eis";
        switch (input.toLowerCase()) {
            case "kekse":
                System.out.println("Nüsse sind gesund");
                break;
            case "pasta":
                System.out.println("Ich esse gerne Pasta");
                break;
            case "eis":
            case "pudding":
                System.out.println("schmeckt gut");
                break;
            default:
        }
        System.out.printf("Kann man %s essen?\n", input);
    }

    private static void unterstriche() {
        long millis = 10 * 86_400_000L;
        long days = millis / 86_400_000L;
        int i = 0b01101001_01001101_11100101_01011110;
        long l = 0x7fff_ffff_ffff_ffffL;
    }


}
