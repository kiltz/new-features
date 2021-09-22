package com.itemfactory;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.domainmodel.Item;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ItemFactory 
{
    public static Item createItem() 
    {
        Logger.getGlobal().log(Level.INFO, "createItem() called");
        return new Item("Example");
    }
}
