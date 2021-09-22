package ch5_java11;

import java.util.Optional;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class OptionalExample
{
    public static void main(final String[] args)
    {
        final Optional<String> optEmpty = Optional.empty();

        if (!optEmpty.isPresent())
            System.out.println("check for empty JDK 10 style");

        if (optEmpty.isEmpty())
            System.out.println("check for empty JDK 11 style");
    }
}
