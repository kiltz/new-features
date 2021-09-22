package ch5_java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class FilesExample 
{
	public static void main(String[] args) throws IOException 
	{
		//write_read_String_V1();
		//write_read_String_V2();
		write_read_String_V3();
	}

	private static void write_read_String_V1() throws IOException 
	{
		final Path destDath = Path.of("ExampleFile.txt");
		
		Files.writeString(destDath, "1: This is a string to file test\n");
		Files.writeString(destDath, "2: Second line");
		
		final String line1 = Files.readString(destDath);
		final String line2 = Files.readString(destDath);
		
		System.out.println(line1);
		System.out.println(line2);
	}
	
	private static void write_read_String_V2() throws IOException 
	{
		final Path destDath = Path.of("AppendExampleFile.txt");
		
		Files.writeString(destDath, "1: This is a string to file test\n");
		Files.writeString(destDath, "2: Second line", StandardOpenOption.APPEND);
		
		final String line1 = Files.readString(destDath);
		final String line2 = Files.readString(destDath);
		
		System.out.println(line1);
		System.out.println(line2);
	}

	private static void write_read_String_V3() throws IOException 
	{
		final Path destDath = Path.of("3-ExampleFile.txt");
		
		Files.writeString(destDath, "1: This is a string to file test\n");
		Files.writeString(destDath, "2: Second line", StandardOpenOption.APPEND);
		
		final String content = Files.readString(destDath);
		content.lines().forEach(System.out::println);
	}
}
