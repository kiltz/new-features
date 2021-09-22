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
public class CompletableFutureJdk9Example
{
    public static void main(final String[] args) throws ExecutionException
    {
        new CompletableFutureJdk9Example().perform();
    }
    
    public void perform() throws ExecutionException
    {
        CompletableFuture.supplyAsync(() -> longRunningCreateMsg(5))
                         .completeAsync(() -> "COMPLETE")
                         .thenAccept(this::notifySubscribers);
        
        CompletableFuture.supplyAsync(() -> longRunningCreateMsg(5))
                         .orTimeout(3, TimeUnit.SECONDS)
                         .exceptionally(ex -> "exception occurred: " + ex)
                         .thenAccept(this::notifySubscribers);
        
        CompletableFuture.supplyAsync(() -> longRunningCreateMsg(5))
                         .completeOnTimeout("TIMEOUT-FALLBACK", 2, TimeUnit.SECONDS)
                         .thenAccept(this::notifySubscribers);    
              
        CompletableFuture.failedFuture(new IllegalStateException())
                         .exceptionally(ex -> { System.out.println("ALWAYS FAILING"); return -1;});
                
        // Give Completablefutures the chance to complete
        sleepInSeconds(10);
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

    private void sleepInSeconds(final int durationInSeconds)
    {
        try
        {
            TimeUnit.SECONDS.sleep(durationInSeconds);
        }
        catch (InterruptedException e)
        {
            /* not possible here */ }
    }
}
