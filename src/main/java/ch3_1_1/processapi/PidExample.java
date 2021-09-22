package ch3_1_1.processapi;

import java.io.IOException;
import java.io.InputStream;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen" / "Java Aktuell"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 / 2019 by Michael Inden 
 */
public class PidExample
{
    public static void main(final String[] args) throws InterruptedException, IOException
    {
        System.out.println("PID old: " + getPidJdk8Style());
        System.out.println("PID new: " + getPidJdk9Style());
    }

    private static long getPidJdk8Style() throws InterruptedException, IOException
    {
        final String[] commands = new String[] { "/bin/sh", "-c", "echo $PPID" };
        final Process proc = Runtime.getRuntime().exec(commands);

        if (proc.waitFor() == 0)
        {
            try (final InputStream in = proc.getInputStream())
            {
                final int available = in.available();
                final byte[] outputBytes = new byte[available];

                in.read(outputBytes);
                final String pid = new String(outputBytes);

                // rein theoretisch wäre hier eine NumberformatException abzufangen
                return Long.parseLong(pid.trim());
            }
        }
        throw new IllegalStateException("PID is not accessable");
    }

    private static long getPidJdk9Style()  
    {
        return ProcessHandle.current().pid();
    }
}
