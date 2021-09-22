package com.inden.javaprofi;

import com.google.common.base.Joiner;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class AutomaticModuleExample 
{
    public static void main(final String[] args) 
    {
        final Joiner joiner = Joiner.on(", ").skipNulls();
        
        System.out.println(joiner.join("Guava", null, "As", null, "AUTOMATIC"));
    }
}