package ch9_java13_14;

import java.time.DayOfWeek;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 14"
 * 
 * @author Michael Inden
 * 
 * Copyright 2020 by Michael Inden 
 */
public class SwitchOldExample
{
    public static void main(final String[] args)
    {
        DayOfWeek day = DayOfWeek.FRIDAY;

        int numLetters = -1;

        switch (day)
        {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                numLetters = 6;
                break;
            case TUESDAY:
                numLetters = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                numLetters = 8;
                break;
            case WEDNESDAY:
                numLetters = 9;
                break;
        };

        System.out.println("Anzahl Buchstaben: " + numLetters);
    }
}
