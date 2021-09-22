package ch8_java12;

import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.util.List;
import java.util.Locale;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class CompactNumberFormatLocaleExample 
{
	public static void main(String[] args) 
	{
		System.out.println("CompactNumberFormatLocaleExample");
		System.out.println("--------------------------------");
		
		List<Locale> locales = List.of(new Locale("en", "US"), 
				new Locale("de", "DE"), new Locale("hi", "IN"), 
				new Locale("ta", "IN"), new Locale("ru", "RU"), 
				new Locale("de", "CH"), new Locale("fr", "CH"),		
		        new Locale("it", "CH"));
		
		locales.forEach(CompactNumberFormatLocaleExample::compactNummber);	
	}


	private static void compactNummber(final Locale locale) 
	{
		System.out.println(locale);
		
		var shortNumFormat = NumberFormat.getCompactNumberInstance(locale, Style.SHORT);		
		shortNumFormat.setMaximumFractionDigits(2);
		
		for (int i=1; i < 6; i++)
		{
			double value = 1_234 * Math.pow(1000,i-1);
			System.out.println("" + value + " => " + shortNumFormat.format(value));
		}
	}
}
