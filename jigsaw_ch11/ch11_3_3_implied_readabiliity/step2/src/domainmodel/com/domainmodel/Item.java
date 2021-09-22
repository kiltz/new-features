package com.domainmodel;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class Item
{
    private String name;
    
    public Item(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
}