package ch5_java11;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class StringRepeatCornerCaseExample
{
    public static void main(final String[] args)
    {
        final String star = "*";
        System.out.println(star.repeat(0));

        final String delimeter = "";
        System.out.println(delimeter.repeat(1_000_000));

        try
        {
            System.out.println(":-(".repeat(-1));
        }
        catch (IllegalArgumentException ex)
        {
            ex.printStackTrace();
        }

        try
        {
            System.out.println(":-(".repeat(Integer.MAX_VALUE));
        }
        catch (IllegalArgumentException ex)
        {
            ex.printStackTrace();
        }
    }
}
