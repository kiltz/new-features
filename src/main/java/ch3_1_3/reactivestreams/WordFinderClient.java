package ch3_1_3.reactivestreams;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class WordFinderClient
{
    public static void main(final String[] args) throws IOException, InterruptedException
    {
        final WordPublisher finder = new WordPublisher("private", getInputFiles());
        WordSubscriber subscriber = new WordSubscriber();
        finder.subscribe(subscriber);
        //finder.subscribe(new First5Subscriber(System.err::println));
        finder.performSearch();

        Thread.sleep(2_000); // auf das Ende der Verarbeitung warten

        finder.terminate();
    }

    private static List<Path> getInputFiles()
    {
        final String srcPath = "src/main/java/";
        return List.of(Paths.get(srcPath + "ch3_1_3/reactivestreams/WordPublisher.java"),
                       Paths.get(srcPath + "ch3_1_3/reactivestreams/WordFinderClient.java"));
    }
    
    // --add-modules jdk.incubator.httpclient
}
