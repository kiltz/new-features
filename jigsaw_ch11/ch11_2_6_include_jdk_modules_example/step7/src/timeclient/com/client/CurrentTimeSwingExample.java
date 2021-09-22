package com.client;

import com.server.TimeInfo;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Beispielprogramm für das Buch "Java 9, 10, 11 und 12 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class CurrentTimeSwingExample 
{
    public static void main(final String[] args)
    {
        final JFrame appFrame = new JFrame("CurrentTimeSwingExample");        
        final JLabel label = new JLabel("Now: " + TimeInfo.getCurrentTime());
        
        appFrame.getContentPane().add(label);
        
        appFrame.setSize(300, 50);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.show();
    }
}