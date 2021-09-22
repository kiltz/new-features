package ch3_1_9.arrays;

import java.util.Arrays;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ArraysIntroExamples
{
    public static void main(String[] args)
    {
        final byte[] string1 = "ABC-DEF-GHI".getBytes();
        final byte[] string2 = "DEF".getBytes();

        System.out.println("compare(all):      " + Arrays.compare(string1, string2));
        System.out.println("compare(DEF, DEF): " + Arrays.compare(string1, 4, 7, string2, 0, 3));
        System.out.println("compare(GHI, DEF): " + Arrays.compare(string1, 8, 11, string2, 0, 3));
    }
}
