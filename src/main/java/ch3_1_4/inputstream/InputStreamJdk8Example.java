package ch3_1_4.inputstream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class InputStreamJdk8Example
{
    public static void main(final String[] args) throws IOException
    {
        final byte[] buffer = { 72, 65, 76, 76, 79 };

        final byte[] resultJdk8 = readAllBytesJdk8(new ByteArrayInputStream(buffer));
        System.out.println(Arrays.toString(resultJdk8));

        transferToJdk8(new ByteArrayInputStream(buffer), System.out);
    }

    private static byte[] readAllBytesJdk8(final InputStream is) throws IOException
    {
        try (final ByteArrayOutputStream os = new ByteArrayOutputStream())
        {
            transferToJdk8(is, os);
            os.flush();

            return os.toByteArray();
        }
    }

    private static void transferToJdk8(final InputStream in, final OutputStream out) throws IOException
    {
        final byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) != -1)
        {
            out.write(buffer, 0, len);
        }
    }
}
