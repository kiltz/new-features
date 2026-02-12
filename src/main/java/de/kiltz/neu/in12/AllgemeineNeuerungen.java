package de.kiltz.neu.in12;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;

public class AllgemeineNeuerungen {
    public static void main(String[] args) throws IOException {
        // indent (man beachte den Zeilenumbruch am Ende!)
        var text1 = "test1";
        System.out.println("'"+text1.indent(4)+"'");
        var text2 = "    test2";
        System.out.println("'"+text2.indent(-4)+"'");

        transformer();

        findeUnterschiede();
    }

    private static void findeUnterschiede() throws IOException {
        // mismatch findet die Position des ersten Unterschieds zweier Dateien
        var filePath1 = Files.createTempFile("test1", ".txt");
        var filePath2 = Files.createTempFile("test2", ".txt");
        Files.writeString(filePath1, "Same Content");
        Files.writeString(filePath2, "Same Content");
        var pos = Files.mismatch(filePath1, filePath2);
        System.out.println("Gleicher Inhalt: " + pos);

        Files.writeString(filePath1, "Same Content");
        Files.writeString(filePath2, "Same Start / Different Content");
        pos = Files.mismatch(filePath1, filePath2);
        System.out.println("Unterschiedlicher Inhalt: " + pos);

        // man beachte das Encoding:
        var fileLatin = Files.createTempFile("enc1", ".latin");
        var fileUtf8 = Files.createTempFile("enc2", ".utf8");        var msg = "Zürich is beautiful. Mainz too";
        Files.writeString(fileLatin, msg, StandardCharsets.ISO_8859_1);
        Files.writeString(fileUtf8, msg, StandardCharsets.UTF_8);
        pos = Files.mismatch(fileLatin, fileUtf8);
        System.out.println("Unterschiedliches Encoding: " +
                " = " + pos);
    }

    private static void transformer() {
        // statt
        var text = "This is a Test";
        text = text.toUpperCase();
        text = text.replaceAll("T", "");
        var result = text.split(" ");
        System.out.println(Arrays.toString(result));

        System.out.println("*".repeat(20));
        // geht es nun mit Transform in einer Anweisung
        result = text.transform(String::toUpperCase).
                transform(str -> str.replaceAll("T", "")).
                transform(str -> str.split(" "));
        System.out.println(Arrays.toString(result));
    }
}
