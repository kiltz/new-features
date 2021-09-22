package ch2;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public interface PrivateMethodsExample
{
    // Interface
    public abstract int method1();

    public abstract String method2();

    public default void calc(final String num1, final String num2)
    {
        final int value1 = Integer.parseInt(num1);
        final int value2 = Integer.parseInt(num2);
        int sum = value1 + value2;
        float avg = (float) sum / 2;
        System.out.println("sum: " + sum + " / avg: " + avg);
    }

    public default void calc2(final int value1, final int value2)
    {
        int sum = value1 + value2;
        float avg = (float) sum / 2;
        System.out.println("sum: " + sum + " / avg: " + avg);
    }
}