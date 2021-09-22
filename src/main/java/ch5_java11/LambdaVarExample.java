package ch5_java11;

import java.util.function.Function;
import java.util.function.IntFunction;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class LambdaVarExample 
{
	public static void main(final String[] args) 
	{	
		IntFunction<Integer> doubleItTyped = (final int x) -> x * 2; 
		IntFunction<Integer> doubleItNoType = x -> x * 2;

		IntFunction<Integer> doubleItWithVar = (var x) -> x * 2; 
					
		Function<String, String> trimmer = (@SomeAnnotation var str) -> str.trim();
		trimmer.apply(null);
	}
}
