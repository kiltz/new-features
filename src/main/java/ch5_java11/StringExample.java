package ch5_java11;

import java.util.stream.Stream;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class StringExample 
{
	public static void main(final String[] args) 
	{
		isBlankExample();
		linesExample();
		repeatExample();
		stripExample();
	}

	private static void isBlankExample() 
	{
		final String exampleText1 = "";
		final String exampleText2 = "    ";		
		final String exampleText3 = " \t \t ";		
		
		System.out.println(exampleText1.isBlank());
		System.out.println(exampleText2.isBlank());
		System.out.println(exampleText3.isBlank());
	}
	
	private static void linesExample() 
	{
		final String exampleText = "1 This is a\n2 multi line\n3 text with\n4 four lines!";		
		final Stream<String> lines = exampleText.lines();
		lines.forEach(System.out::println);		
	}
	
	private static void repeatExample() 
	{
		final String star = "*";		
		System.out.println(star.repeat(30));
		
		final String delimeter = " -*- ";		
		System.out.println(delimeter.repeat(6));		
	}
	
	private static void stripExample() 
	{
		final String exampleText1 = "  abc ";
		final String exampleText2 = " \t XYZ \t ";		
		
		System.out.println("trim():  '" + exampleText1.trim()+ "'");
		System.out.println("trim():  '" + exampleText2.trim()+ "'");
		System.out.println("strip(): '" + exampleText1.strip()+ "'");
		System.out.println("strip(): '"  + exampleText2.strip()+ "'");
		System.out.println("sL()     '" + exampleText2.stripLeading()+ "'");
		System.out.println("sT()     '" + exampleText2.stripTrailing() + "'");
	}
}
