package ch3_1_additional.unicode;

import java.io.UnsupportedEncodingException;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class Unicode8Example
{
    public static void main(final String[] args) throws UnsupportedEncodingException
    {
        final String text = "Text \u00B0 \u1801 \u25D0 \u2A0C \u83fb --- \u1f605 \u1f310 \u1f575 \u1F917";
        System.out.println(text);
    }
}