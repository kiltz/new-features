package com.inden.javaprofi.auto_uses_unnamed;

import com.inden.javaprofi.UseGuavaFromClassPathExample;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class AutomaticAndUnnamedModuleExample 
{
    public static void main(final String[] args) throws Exception
    {
        System.out.println("AutomaticAndUnnamedModuleExample");
        
        UseGuavaFromClassPathExample.joinWithGuava("Guava", "From ClassPath",
                                                   "Referenced By", 
                                                   "Automatic Module");
    }
}