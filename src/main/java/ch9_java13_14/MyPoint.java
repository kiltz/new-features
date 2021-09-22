package ch9_java13_14;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 14"
 * 
 * @author Michael Inden
 * 
 * Copyright 2020 by Michael Inden 
 */
record MyPoint(int x, int y)
{
    public MyPoint(final String values)
    {
        this(Integer.parseInt(values.split(",")[0]), Integer.parseInt(values.split(",")[1]));
    }
    
    public static void main(String[] args)
    {
        final MyPoint myPoint = new MyPoint("72,71");
        System.out.println(myPoint);
    }
}