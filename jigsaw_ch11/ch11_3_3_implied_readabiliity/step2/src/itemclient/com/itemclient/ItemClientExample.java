package com.itemclient;

import com.domainmodel.Item;
import com.itemfactory.ItemFactory;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ItemClientExample
{
    public static void main(final String[] args)
    {
        final Item item = ItemFactory.createItem();
        System.out.println(item);
    }
}