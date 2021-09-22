package ch3_1_1.processapi;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen" / "Java Aktuell"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ProcessHandleExample
{
    public static void main(final String[] args) 
    {
        final ProcessHandle current = ProcessHandle.current();
        printInfo(current);
    }

    private static void printInfo(final ProcessHandle current)
    {
        System.out.println("PID:       " + current.pid());
        System.out.println("Info:      " + current.info());
        System.out.println("Command:   " + current.info().command());
        System.out.println("CPU-Usage: " + current.info().totalCpuDuration());
    }
}
