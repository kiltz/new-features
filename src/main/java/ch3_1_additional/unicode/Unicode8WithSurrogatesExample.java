package ch3_1_additional.unicode;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class Unicode8WithSurrogatesExample
{
    public static void main(final String[] args)  
    {
        final String text = "Text Surr \u00B0 \u1801 \u25D0 \u2A0C \u83fb --- " +
                             toSurrogates(0x1f605) + toSurrogates(0x1f310) +
                             toSurrogates(0x1f575) + toSurrogates(0x1F917);
        System.out.println(text);      
    }
    
    private static String toSurrogates(final int orig)
    {
        return new String(new char[]{Character.highSurrogate(orig), 
                                     Character.lowSurrogate(orig)});
    }
    
    // Mit Bit-Manipulation selbst gestrickt ;-)    
    private static String toSurrogatesOwn(final int orig)
    {
        final int[] surrogates = calcSurrogates(orig);
        return new String(new char[]{(char) surrogates[0], 
                                     (char)surrogates[1]} );
    }
    
    private static int[] calcSurrogates(final int orig)
    {
        final int twenty = orig - 0x010000;
        
        final int topTen = twenty >> 10;
        final int lowTen = (twenty & 0b01111111111);
        
        final int highSurr = 0xD800 + topTen;
        final int lowSurr = 0xDC00 + lowTen;
        
        return new int[] {highSurr, lowSurr};
    }
}