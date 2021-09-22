package ch9_java13_14;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 14"
 * 
 * @author Michael Inden
 * 
 * Copyright 2020 by Michael Inden 
 */
public class NPE_Example
{
    public static void main(final String[] args)
    {
        A a = null;
        a.value = "ERROR";
    }
}