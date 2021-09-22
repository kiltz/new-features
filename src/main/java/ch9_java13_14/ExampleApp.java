package ch9_java13_14;

import java.awt.Window;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 14"
 * 
 * @author Michael Inden
 * 
 * Copyright 2020 by Michael Inden 
 */
public class ExampleApp
{
    public static void main(final String[] args)
    {
        System.out.println(getWindowManager().getWindow(5).size().width());
    }

    public static WindowManager getWindowManager()
    {
        return new WindowManager();
    }

    public static class WindowManager
    {
        public Window getWindow(final int i)
        {
            return null;
        }
    }
    
    public static record Window(Size size) {};
    public static record Size(int width, int height) {};
}