package com.inden.javaprofi;

import com.google.common.base.Joiner;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class UseGuavaFromClassPathInNamedModuleExample 
{
    public static void main(final String[] args) 
    {
        joinWithGuava("Guava", null, "From", "ClassPath");
    }

    // diese Methode benötigen wir später noch    
    public static void joinWithGuava(final String... strings)
    {
        final Joiner joiner = Joiner.on(", ").skipNulls();
        
        System.out.println(joiner.join(strings));
    }
}
