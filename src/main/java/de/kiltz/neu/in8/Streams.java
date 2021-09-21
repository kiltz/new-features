package de.kiltz.neu.in8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    private static final List<String> TAGE = Arrays.asList("Montag", "Dienstag", "Mittwoch",
            "Donnerstag", "Freitag", "Samstag", "Sonntag");

    public static void main(String[] args) {
        einstieg();
        filtern();
        mappen();
        sortieren();
        matchenUndFinden();

    }

    private static void matchenUndFinden() {
        boolean alleStartenMitM = TAGE.stream().allMatch(s -> s.startsWith("M"));
        System.out.println("Match 1: "+ alleStartenMitM);
        boolean wenigstensEinerStartenMitM = TAGE.stream().anyMatch(s -> s.startsWith("M"));
        System.out.println("Match 2: "+ wenigstensEinerStartenMitM);
        boolean kinerStartetMitM = TAGE.stream().noneMatch(s -> s.startsWith("M"));
        System.out.println("Match 3: "+ kinerStartetMitM);

        Optional<String> erstesD = TAGE.stream().filter(s -> s.startsWith("D")).findFirst();
        System.out.println("Find 1: "+ erstesD.orElse("Kein D"));
        Optional<String> erstesZ = TAGE.stream().filter(s -> s.startsWith("Z")).findFirst();
        System.out.println("Find 2: "+ erstesZ.orElse("Kein Z"));
        Optional<String> irgendEinD = TAGE.stream().filter(s -> s.startsWith("D")).findAny();
        System.out.println("Find 3: "+ irgendEinD.orElse("Kein D"));


    }

    private static void sortieren() {
        System.out.println("Sortieren 1");
        TAGE.stream().sorted().forEach(System.out::println);
        System.out.println("Sortieren 2");
        TAGE.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);
        System.out.println("Dubletten 1");
        Stream.of(3, 5, 7, 2, 4, 6, 8, 7).distinct().sorted().forEach(System.out::println);

    }

    private static void mappen() {
        final Function<String, String> erstenZweiBuchstaben = s -> s.substring(0, 2);
        System.out.println("Mappen 1");
        TAGE.stream().map(erstenZweiBuchstaben).forEach(System.out::println);

        System.out.println("Mappen 2");
        List<Integer> laengen = TAGE.stream().map(s -> s.length()).collect(Collectors.toList());
        laengen.forEach(System.out::println);

    }

    private static void filtern() {
        final Predicate<String> beginntMitM = s -> s.startsWith("M");
        System.out.println("Filter 1");
        TAGE.stream().filter(beginntMitM).forEach(System.out::println);
        System.out.println("Filter 2");
        TAGE.stream().filter(String::isEmpty).forEach(System.out::println);
        System.out.println("Filter 3");
        TAGE.stream().filter(beginntMitM).filter(tag -> tag.contains("o")).forEach(System.out::println);


    }

    private static void einstieg() {

        List<String> kurzeTage = TAGE.stream().map(s -> s.substring(0, 2)).collect(Collectors.toList());

        kurzeTage.forEach(System.out::println);

        String alleKurzenTage = TAGE.stream().peek(System.out::println).map(s -> s.substring(0, 2)).collect(Collectors.joining(", "));
        System.out.println(alleKurzenTage);
    }
}
