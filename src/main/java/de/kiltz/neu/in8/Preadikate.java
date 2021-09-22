package de.kiltz.neu.in8;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Preadikate {
    private static final List<String> TAGE = Arrays.asList("Montag", "Dienstag", "Mittwoch",
            "Donnerstag", "Freitag", "Samstag", "Sonntag");

    public static void main(String[] args) {
        fuerJeden();
        praedikat();
        komplexePreadikate();
        einstelligkeit();
        einstelligkeit2();

    }

    private static void einstelligkeit2() {
        final List<String> names = createDemoNames();
        // Spezialbehandlung von null Werten
        final UnaryOperator<String> mapNullToEmpty = str -> str == null ?
                "" : str;
        names.replaceAll(mapNullToEmpty);
        // Leerzeichen abschneiden
        names.replaceAll(String::trim);
        // Leereinträge herausfiltern
        names.removeIf(String::isEmpty);
        System.out.println(names);
    }

    private static List<String> createDemoNames() {

        final List<String> names = new ArrayList<>();
        names.add(" Max");
        // Leereintrag
        names.add("");
        // potenziell auch ein "Leereintrag"
        names.add(" ");
        names.add(" Andy ");
        // für den Null-Mapper
        names.add(null);
        names.add("Stefan ");
        return names;
    }

    private static void einstelligkeit() {
        // Mark
        final UnaryOperator<String> markTextWithM = str -> str.startsWith("M") ?
                ">>" + str.toUpperCase() + "<<" : str;
        printResult("Mark 1", "unchanged", markTextWithM);
        printResult("Mark 2", "Michael", markTextWithM);
        // Trim
        final UnaryOperator<String> trimmer = String::trim;
        printResult("Trim 1", "no_trim", trimmer);
        printResult("Trim 2", " trim me", trimmer);
        // Map
        final UnaryOperator<String> mapNullToEmpty = str -> str == null ?
                "" : str;
        printResult("Map same", "same", mapNullToEmpty);
        printResult("Map null", null, mapNullToEmpty);
    }

    private static void printResult(final String text, final String value,
                                    final UnaryOperator<String> op) {
        System.out.println(text + ": ’" + value + "’ --> ’" + op.apply(value)
                + "'");
    }

    private static void komplexePreadikate() {
        final List<Person> persons = createDemoData();
        // Einfache Prädikate formulieren
        final Predicate<Person> isAdult = person -> person.getAge() >= 18;
        final Predicate<Person> isMale = person -> person.getGender() == Gender.MALE;
        // Negation einzelner Prädikate
        final Predicate<Person> isYoung = isAdult.negate();
        final Predicate<Person> isFemale = isMale.negate();
        // Kombination von Prädikaten mit AND
        final Predicate<Person> boys = isMale.and(isYoung);
        final Predicate<Person> women = isFemale.and(isAdult);
        // Kombination von Prädikaten mit OR
        final Predicate<Person> boysOrWomen = boys.or(women);
        persons.removeIf(boysOrWomen);
        System.out.println("Persons: " + persons);
    }

    private static List<Person> createDemoData() {
        final List<Person> persons = new ArrayList<>();
        persons.add(new Person("Michael", 44));
        persons.add(new Person("Barbara", 22, Gender.FEMALE));
        persons.add(new Person("Lili", 17, Gender.FEMALE));
        persons.add(new Person("Tom", 8));
        persons.add(new Person("Björn", 7));
        return persons;
    }

    private static void praedikat() {
        final Predicate<String> isNull = str -> str == null;
        final Predicate<String> isEmpty = String::isEmpty;
        final Predicate<Person> isAdult = person -> person.getAge() >= 18;
        System.out.println("isNull(''): " + isNull.test(""));
        System.out.println("isEmpty(''): " + isEmpty.test(""));
        System.out.println("isEmpty(’Pia’): " + isEmpty.test("Pia"));
        System.out.println("isAdult(Pia): " + isAdult.test(new Person("Pia",
                55)));
    }

    private static void fuerJeden() {
        final List<String> names = Arrays.asList("Andi", "Mike", "Ralph", "Stefan");
        // Klassische Variante mit Iterator
        final Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        // ... oder alternativ mit indiziertem Zugriff
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
        // JDK 5 Schreibweise mit "for each"
        for (final String name : names) {
            System.out.println(name);
        }
        // Interne Iteration in drei Varianten
        names.forEach((String name) -> {
            System.out.println(name);
        });
        names.forEach(name -> System.out.println(name));
        names.forEach(System.out::println);
    }
}
