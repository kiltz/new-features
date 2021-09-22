package ch3_1_1.processapi;

import java.io.IOException;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen" / "Java Aktuell"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ControlProcessExample
{
    public static void main(final String[] args) throws IOException, InterruptedException
    {
        // Prozess erzeugen
        final String command = "sleep 60s";
        final String commandWin = "cmd timeout 60";
        final Process sleeper = Runtime.getRuntime().exec(command);
        System.out.println("Started process is " + sleeper.pid());

        // Process => ProcessHandle
        final ProcessHandle sleeperHandle = ProcessHandle.of(sleeper.pid()).orElseThrow(IllegalStateException::new);
        final ProcessHandle sleeperHandle2 = sleeper.toHandle();
        System.out.println("Same handle? " + sleeperHandle.equals(sleeperHandle2));

        // Exit Handler registrieren
        final Runnable exitHandler = () -> System.out.println("exitHandler called");
        sleeperHandle.onExit().thenRun(exitHandler);
        System.out.println("Registered exitHandler");

        // Den Prozess zerstören und ein wenig warten,
        // damit onExit() ausgeführt werden kann
        System.out.println("Destroying process " + sleeperHandle.pid());
        sleeperHandle.destroy();
        Thread.sleep(500);
    }
}
