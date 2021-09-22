package ch8_java12;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class CompactNumberFormatExample 
{
	public static void main(final String args[]) 
	{
		var shortFormat = getUsCompactNumberFormat(NumberFormat.Style.SHORT);
		formatNumbers("SHORT", shortFormat);

		var longFormat = getUsCompactNumberFormat(NumberFormat.Style.LONG);
		formatNumbers("LONG", longFormat);
	}

	private static NumberFormat getUsCompactNumberFormat(NumberFormat.Style style) 
	{
		return NumberFormat.getCompactNumberInstance(Locale.US, style);
	}

	private static void formatNumbers(final String style,
			                          final NumberFormat shortFormat) 
	{
		System.out.println("\nNumberFormat " + style);
				
		System.out.println("Result: " + shortFormat.format(10_000));
		System.out.println("Result: " + shortFormat.format(123_456));
		System.out.println("Result: " + shortFormat.format(1_234_567));
		System.out.println("Result: " + shortFormat.format(1_950_000_000));
	}
}