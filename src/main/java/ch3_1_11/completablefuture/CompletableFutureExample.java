package ch3_1_11.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class CompletableFutureExample
{
    public static void main(final String[] args) throws InterruptedException, ExecutionException
    {
        new CompletableFutureExample().perform();
    }

    public void perform() throws InterruptedException, ExecutionException
    {
        // supplyAsync(): eine einzelne Aktion parallel zum Aufrufer ausführen
        final CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> longRunningCreateMsg(5));

        // thenAccept(): Aktion nach Abschluss der Ausführung 
        supplyAsync.thenAccept(this::notifySubscribers);

        // exceptionally(): Exception-Mapping
        CompletableFuture.supplyAsync(this::failingMsg).exceptionally(ex -> "FAILED")
                         .thenAccept(this::notifySubscribers);

        System.out.println(getCurrentThread() + " perform()");
    }

    public String longRunningCreateMsg(final int durationInSecs)
    {
        System.out.println(getCurrentThread() + " >>> longRunningCreateMsg");
        sleepInSeconds(durationInSecs);
        System.out.println(getCurrentThread() + " <<< longRunningCreateMsg");

        return "longRunningCreateMsg";
    }

    public String getCurrentThread()
    {
        return Thread.currentThread().getName();
    }

    public void notifySubscribers(final String msg)
    {
        System.out.println(getCurrentThread() + " notifySubscribers: " + msg);
    }

    public String failingMsg()
    {
        throw new IllegalStateException("ISE");
    }

    private void sleepInSeconds(final int durationInSeconds)
    {
        try
        {
            TimeUnit.SECONDS.sleep(durationInSeconds);
        }
        catch (InterruptedException e)
        {
            /* not possible here */
        }
    }
}
