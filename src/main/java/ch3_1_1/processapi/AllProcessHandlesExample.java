package ch3_1_1.processapi;

import java.util.stream.Stream;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen" / "Java Aktuell"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 / 2019 by Michael Inden 
 */
public class AllProcessHandlesExample
{
    public static void main(final String[] args)  
    {
        System.out.println("\n\nAll Processes:");
        showInfosForAllProcesses();
    }

    private static void showInfosForAllProcesses()
    {
        ProcessHandle.allProcesses().forEach(processHandle -> 
        {
            final Stream<ProcessHandle> children = processHandle.children();
            final long count = children.count();
            if (count > 0)
            {
                System.out.println("Info: " + processHandle.info() + " has " + count + " children");
            }
        });
    }
}
