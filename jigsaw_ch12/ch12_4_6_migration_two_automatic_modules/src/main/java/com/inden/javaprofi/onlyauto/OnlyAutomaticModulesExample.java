package com.inden.javaprofi.onlyauto;

import com.inden.javaprofi.UseGuavaFromClassPathExample;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class OnlyAutomaticModulesExample 
{
    public static void main(final String[] args) throws Exception
    {
        System.out.println("OnlyAutomaticModulesExample");
        
        UseGuavaFromClassPathExample.joinWithGuava("Both", "As", 
                                                   "Automatic Module");
    }
}