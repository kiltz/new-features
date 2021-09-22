package ch9_java13_14;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 14"
 * 
 * @author Michael Inden
 * 
 * Copyright 2020 by Michael Inden 
 */
public class InstanceOfExample
{
    public static void main(final String[] args)
    {
        Object obj = "Hallo Java 14";
        if (obj instanceof String str)
        {
            // Hier kann man str nutzen
            System.out.println("Länge: " + str.length());
        }
        else
        {
            System.out.println(obj.getClass());
        }

        // und sogar noch netter
        //if (obj instanceof String s2 || s2.length() > 5) {
        if (obj instanceof String str2 && str2.length() > 5)
        {
            System.out.println("Länge: " + str2.length());
        }
    }
}
