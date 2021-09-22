package de.kiltz.neu.in8;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class EineFlatMap {
    public static void main(String[] args) throws IOException {
        final Path exampleFile = Paths.get("src/main/resources/Example.txt");
        // Datei einlesen neu in JDK 8: Siehe dazu Kapitel 6
        final List<String> contents = Files.readAllLines(exampleFile);
        // Daraus einen Stream von Worten machen
        final Stream<String> words = contents.stream().
                flatMap(line -> Stream.of(line.split(" ")));
        // Prädikate für kurze Wörter
        final Predicate<String> isShortWord = word -> word.length() <= 3;
        final Predicate<String> notIsShortWord = isShortWord.negate();
        // Prädikate für spezielle und zu ignorierende Wörter
        final List<String> ignoreableWords = Arrays.asList("diese", "sind", "werden");
        final Predicate<String> isIgnorableWord = word -> {
            return ignoreableWords.contains(word.toLowerCase());
        };
        final Predicate<String> isSignificantWord = isIgnorableWord.negate();
        // Filterung basierend auf den Prädikaten
        final Stream<String> filteredContents = words.map(String::trim).
                filter(notIsShortWord).
                filter(isSignificantWord);
        filteredContents.forEach(it -> System.out.print(it + ", "));

    }
}
