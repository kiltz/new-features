package ch5_java11.http2;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class Http2AsyncExample
{
	public static void main(final String[] args) throws Exception
	{
	    final URI uri = new URI("https://www.oracle.com/index.html");
		
		final HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
		final BodyHandler<String> asString = HttpResponse.BodyHandlers.ofString();
		
		final HttpClient httpClient = HttpClient.newHttpClient();
		final CompletableFuture<HttpResponse<String>> asyncResponse = httpClient.sendAsync(request, asString);
		asyncResponse.thenAccept(response -> printResponseInfo(response));
		
		waitForCompletion();
		if (asyncResponse.isDone())
		{
		    final HttpResponse<String> response = asyncResponse.get();
		    printResponseInfo(response);
		}
		else
		{
		    asyncResponse.cancel(true);
		    System.err.println("timeout");
		}
	    
	    step2();
	}

	private static void step2() throws URISyntaxException, InterruptedException, ExecutionException {
		final URI uri = new URI("https://www.oracle.com/index.html");
		
	    final HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
	    final BodyHandler<Path> asFile = HttpResponse.BodyHandlers.ofFile(Paths.get("./download.txt"));
	
	    final HttpClient httpClient = HttpClient.newHttpClient();
	    final CompletableFuture<HttpResponse<Path>> asyncResponse = httpClient.sendAsync(request, asFile);
	    asyncResponse.thenAccept(response -> printResponseInfoFile(response));
	
	    waitForCompletion();
	    if (asyncResponse.isDone())
	    {
	        final HttpResponse<Path> response = asyncResponse.get();
	        printResponseInfoFile(response);
	    }
	    else
	    {
	        asyncResponse.cancel(true);
	        System.err.println("timeout");
	    }
	}
	
	private static void printResponseInfoFile(final HttpResponse<Path> response)
	{
	    final int responseCode = response.statusCode();
	    final Path responseBody = response.body();
	
	    System.out.println("Status: " + responseCode);
	    System.out.println("Body:   " + responseBody);
	}
	
	private static void waitForCompletion() throws InterruptedException
	{
	    for (int i = 0; i < 10; i++)
	    {
	        System.out.println("Step " + i);
	        Thread.sleep(200);
	    }
	}
	
	private static void printResponseInfo(final HttpResponse<String> response)
	{
	    final int responseCode = response.statusCode();
	    final String responseBody = response.body();
	
	    System.out.println("Status: " + responseCode);
	    System.out.println("Body:   " + responseBody);
	}
}