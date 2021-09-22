package ch12_3_3;

import ch12_3_3.domain.Person;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ReflectionUtilsUsageExample
{
    public static void main(final String[] args) 
    {
        final ReflectionAttributeAccessor raa = new ReflectionAttributeAccessor();
        final Object value = raa.getAttributeValue(new Person("Micha"), "name");

        System.out.println("Value = " + value);
    }
}