package de.kiltz.neu.in8;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Streams {
    private static final List<String> TAGE = Arrays.asList("Montag", "Dienstag", "Mittwoch",
            "Donnerstag", "Freitag", "Samstag", "Sonntag");

    public static void main(String[] args) {
//        einstieg();
//        intStreams();
//        filtern();
//        mappen();
//        sortieren();
//        matchenUndFinden();
        sammeln();

    }

    private static void sammeln() {
        final Map<String, Collector<Integer, ?, ?>> collectorsMap = new
                HashMap<>();
        collectorsMap.put("counting(): ", counting());
        collectorsMap.put("summingInt(): ", summingInt(x -> x));
        collectorsMap.put("averagingInt(): ", averagingInt(x -> x));
        collectorsMap.put("maxBy(): ", maxBy(Integer::compare));
        collectorsMap.put("minBy(): ", minBy(Integer::compare));
        collectorsMap.put("summarizingInt(): ", summarizingInt(x -> x));
        for (final Map.Entry<String, Collector<Integer, ?, ?>> mapping :
                collectorsMap.entrySet()) {
            final Collector<Integer, ?, ?> collector = mapping.getValue();
            final List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            System.out.println(mapping.getKey() +
                    ints.stream().collect(collector));
        }

    }

    private static void intStreams() {
        final List<String> names = Arrays.asList("Mike", "Stefan", "Nikolaos");
        Stream<String> values = names.stream(). // --> Stream<String>
                mapToInt(String::length). // --> Stream
                asLongStream(). // --> LongStream
                boxed(). // --> Stream<Long>
                mapToDouble(x -> x * .75).// --> doubleStream
                mapToObj(val -> "Val: " + val); // --> Stream<String>
        values.forEach(System.out::println);
    }

    private static void matchenUndFinden() {
        boolean alleStartenMitM = TAGE.stream().allMatch(s -> s.startsWith("M"));
        System.out.println("Match 1: " + alleStartenMitM);
        boolean wenigstensEinerStartenMitM = TAGE.stream().anyMatch(s -> s.startsWith("M"));
        System.out.println("Match 2: " + wenigstensEinerStartenMitM);
        boolean kinerStartetMitM = TAGE.stream().noneMatch(s -> s.startsWith("M"));
        System.out.println("Match 3: " + kinerStartetMitM);

        Optional<String> erstesD = TAGE.stream().filter(s -> s.startsWith("D")).findFirst();
        System.out.println("Find 1: " + erstesD.orElse("Kein D"));
        Optional<String> erstesZ = TAGE.stream().filter(s -> s.startsWith("Z")).findFirst();
        System.out.println("Find 2: " + erstesZ.orElse("Kein Z"));
        Optional<String> irgendEinD = TAGE.stream().filter(s -> s.startsWith("D")).findAny();
        System.out.println("Find 3: " + irgendEinD.orElse("Kein D"));


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
        List<Integer> laengen = TAGE.stream().map(String::length).collect(Collectors.toList());
        laengen.forEach(System.out::println);

        System.out.println("Mappen 3");
        final List<Person> persons = new ArrayList<>();
        persons.add(new Person("Barbara", 40, Gender.FEMALE));
        persons.add(new Person("Yannis", 5, "Hamburg"));
// Mapping auf Name mit Lambda
        final Stream<Person> adults = persons.stream().filter(Person::isAdult);
        final Stream<String> namesStream = adults.map(Person::getName);
// Mapping auf Alter mit Methodenreferenz
        final Stream<Integer> agesStream = persons.stream().map(Person::getAge).
                filter(age -> age >= 18);
        namesStream.forEach(System.out::println);
        agesStream.forEach(System.out::println);

    }

    private static void filtern() {
        final Predicate<String> beginntMitM = s -> s.startsWith("M");
        System.out.println("Filter 1");
        TAGE.stream().filter(beginntMitM).forEach(System.out::println);
        System.out.println("Filter 2");
        TAGE.stream().filter(String::isEmpty).forEach(System.out::println);
        System.out.println("Filter 3");
        TAGE.stream().filter(beginntMitM).filter(tag -> tag.contains("o")).forEach(System.out::println);

        final List<Person> persons = new ArrayList<>();
        persons.add(new Person("Micha", 43, "Zürich"));
        persons.add(new Person("Barbara", 40, Gender.FEMALE));
        persons.add(new Person("Yannis", 5, "Hamburg"));
        // final Predicate<Person> isAdult = person --> person.getAge() >= 18;
        final Stream<Person> adults = persons.stream().filter(Person::isAdult);
        System.out.println("Filter 4");
        adults.forEach(System.out::println);
    }

    private static void einstieg() {

        List<String> kurzeTage = TAGE.stream().map(s -> s.substring(0, 2)).collect(Collectors.toList());

        kurzeTage.forEach(System.out::println);

        String alleKurzenTage = TAGE.stream().peek(System.out::println).map(s -> s.substring(0, 2)).collect(Collectors.joining(", "));
        System.out.println(alleKurzenTage);
    }
}
