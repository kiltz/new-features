package de.kiltz.neu.in11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class AllgemeineNeuerungen {
    public static void main(String[] args) throws IOException {
        neueStringHilfsmethoden();
        neuesInNio();

        // Optional: isEmpty ergänzt isPresent => keine Negation im if
    }

    private static void neuesInNio() throws IOException {
        var pfad = Path.of("TestDatei.txt");
        Files.writeString(pfad, "Zeile 1\n");
        Files.writeString(pfad, "Zeile 2", StandardOpenOption.APPEND);

        final var inhalt = Files.readString(pfad);
        System.out.println(inhalt);
        System.out.println("*".repeat(20));
        inhalt.lines().forEach(System.out::println);
    }

    private static void neueStringHilfsmethoden() {
        // isBlank
        var text = " ";
        System.out.println(text.isBlank());
        var mehrereZeilen = "eins\nzwei\ndrei";

        var einMitTag = "  \t   ";
        System.out.println("'"+einMitTag.trim()+"'");
        System.out.println(einMitTag.trim().isEmpty());
        System.out.println(einMitTag.isEmpty());
        System.out.println(einMitTag.isBlank());
        // lines
        Stream<String> zeilenAlsStream = mehrereZeilen.lines();
        zeilenAlsStream.forEach(s -> System.out.println(":\t" + s));
        // repeat
        System.out.println("*".repeat(20));
        var strafarbeit = "Don't repeat yourself!\n".repeat(100);
        System.out.println(strafarbeit);
        System.out.println("*".repeat(20));

        // Strip
        var text1 = "  abc  ";
        var text2 = " \t def \t ";
        System.out.println("'" + text1.strip() + "'");
        System.out.println("'" + text2.strip() + "'");
        System.out.println("'" + text2.stripLeading() + "'");
        System.out.println("'" + text2.stripTrailing() + "'");
    }
}
