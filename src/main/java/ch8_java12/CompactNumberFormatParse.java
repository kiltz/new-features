package ch8_java12;

import java.text.NumberFormat;
import static java.text.NumberFormat.Style;
import java.text.ParseException;
import java.util.Locale;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class CompactNumberFormatParse
{
    public static void main(String[] args) throws ParseException
    {
        System.out.println("US/SHORT parsing:");

        var shortFormat = NumberFormat.getCompactNumberInstance(Locale.US, Style.SHORT);
        System.out.println(shortFormat.parse("1 K")); // ACHTUNG
        System.out.println(shortFormat.parse("1K"));
        System.out.println(shortFormat.parse("1M"));
        System.out.println(shortFormat.parse("1B"));

        System.out.println("\nUS/LONG parsing:");

        var longFormat = NumberFormat.getCompactNumberInstance(Locale.US, Style.LONG);
        System.out.println(longFormat.parse("1 thousand"));
        System.out.println(longFormat.parse("1 million"));
        System.out.println(longFormat.parse("1 billion"));
    }
}