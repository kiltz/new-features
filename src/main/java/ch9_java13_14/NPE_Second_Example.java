package ch9_java13_14;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 14"
 * 
 * @author Michael Inden
 * 
 * Copyright 2020 by Michael Inden 
 */
public class NPE_Second_Example
{
    public static void main(final String[] args)
    {
        try
        {
            final String[] stringArray = { null, null, null };
            final int errorPos = stringArray[2].lastIndexOf("ERROR");
        }
        // In der Praxis bitte keine NullPointerException fangen,
        // hier nur damit die folgenden Anweisungen ausgeführt werden 
        catch (final NullPointerException e)
        {
            e.printStackTrace();
        }
        try
        {
            final Integer value = null;
            final int sum = value + 3;
        }
        catch (final NullPointerException e)
        {
            e.printStackTrace();
        }
    }
}