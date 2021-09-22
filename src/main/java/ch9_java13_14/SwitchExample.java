package ch9_java13_14;

import java.time.DayOfWeek;
import java.time.Month;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 14"
 * 
 * @author Michael Inden
 * 
 * Copyright 2020 by Michael Inden 
 */
public class SwitchExample
{
    enum Color {
        RED, GREEN, BLUE, YELLOW, ORANGE
    };

    public static void main(final String[] args)
    {
        int month = 7;
        String monthString;
        switch (month)
        {
            case 1:
                monthString = "January";
                break;
            case 2:
                monthString = "February";
                break;
            case 3:
                monthString = "March";
                break;
            //...
            default:
                monthString = "N/A";
        }
        System.out.println("OLD: " + month + " = " + monthString); // N/A

        // FIESE default mitten in switch
        switch (month)
        {
            case 1:
                monthString = "January";
                break;
            default:
                monthString = "N/A"; // hier auch noch fallthrough
            case 2:
                monthString = "February";
                break;
            case 3:
                monthString = "March";
                break;
            //...

        }
        System.out.println("OLD2: " + month + " = " + monthString); // February

        // Old version: zwar konnte man nicht nur Konstanten angeben, aber
        // es gab doch einige Nachteile
        // - FALL-THROUGH
        // - keine Angabe meherer Werte
        // - benötigt "künstliche Hilfsvariable"
        Color color = Color.GREEN;
        int numOfChars;
        switch (color)
        {
            case RED:
                numOfChars = 3;
                break;
            case GREEN:
                numOfChars = 5; /* break; UPS: FALL-THROUGH */;
            case YELLOW:
                numOfChars = 6;
                break;
            case ORANGE:
                numOfChars = 6;
                break;
            default:
                numOfChars = -1;
        }

        System.out.println("OLD color: " + color + " ==> " + numOfChars);

        // Verbesserung 1: break mit Ergebnis auch bei alter Syntax
        // Verbesserung 2: Rückgabe eines Werts auch bei alter Syntax möglich
        // Verbesserung 3: Mehrere Werte in einem CASE
        switchYieldReturnsValue(Color.GREEN);

        // Verbesserung 1: ohne break und kein Fallthrough
        final int value = 3;
        String numericString = switchAssignment(value);

        // Der Java-Compiler erlaubt das, Eclipse nicht!!
        System.out.println("NEW: " + value + " ==> " + numericString);

        DayOfWeek day = DayOfWeek.FRIDAY;
        int numOfLetters = -1;

        switch (day)
        {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                numOfLetters = 6;
                break;
            case TUESDAY:
                numOfLetters = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                numOfLetters = 8;
                break;
            case WEDNESDAY:
                numOfLetters = 9;
                break;
        }

        // Verbesserung 2: Rückgabe eines Werts möglich
        // Verbesserung 3: Mehrere Werte in einem CASE
        int numLetters = dayToLength();

        System.out.println("Anzahl Buchstaben: " + numLetters);

        monthToNameOld();
        System.out.println("NEW: " + month + " = " + monthToName(Month.FEBRUARY));
    }

    private static int dayToLength()
    {
        DayOfWeek day = DayOfWeek.FRIDAY;
        int numLetters = switch (day)
        {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
        };
        return numLetters;
    }

    private static String switchAssignment(final int value)
    {
        String numericString = ""; // In Eclipse nötig
        switch (value)
        {
            case 1 -> numericString = "one";
            case 2 -> numericString = "two";
            case 3 -> numericString = "three";
            case 4 -> numericString = "four";
            default -> numericString = "N/A";
        }
        return numericString;
    }

    public static void switchYieldReturnsValue(Color color)
    {
        int numOfChars = switch (color)
        {
            case RED:
                yield 3;
            case GREEN:
                yield 5;
            case YELLOW, ORANGE:
                yield 6;
            default:
                yield -1;
        };
        System.out.println("color: " + color + " ==> " + numOfChars);
    }

    static void monthToNameOld()
    {
        Month month = Month.JULY;

        String monthString = "";
        switch (month)
        {
            case JANUARY:
                monthString = "January";
                break;
            default:
                monthString = "N/A"; // hier auch noch fall through
            case FEBRUARY:
                monthString = "February";
                break;
            case MARCH:
                monthString = "March";
                break;
            case JULY:
                monthString = "July";
                break;
        }
        System.out.println("OLD2: " + month + " = " + monthString); // February
    }

    static String monthToName(Month month)
    {
        return switch (month)
        {
            case JANUARY -> "January";
            default -> "N/A"; // hier auch noch fall through
            case FEBRUARY -> "February";
            case MARCH -> "March";
            case JULY -> "JULY";
        };
    }

}
