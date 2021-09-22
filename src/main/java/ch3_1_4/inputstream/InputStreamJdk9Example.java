package ch3_1_4.inputstream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class InputStreamJdk9Example
{
    public static void main(final String[] args) throws IOException
    {
        final byte[] buffer = { 72, 65, 76, 76, 79 };

        final byte[] result = new ByteArrayInputStream(buffer).readAllBytes();
        System.out.println(Arrays.toString(result));

        new ByteArrayInputStream(buffer).transferTo(System.out);
    }
}
