package ch2;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class DepecationExample
{
    public static void main(final String[] args)
    {
        someOldMethod();
    }

    /**
     * @deprecated this method is replaced by someNewMethod() which is more stable
     */
    @Deprecated(since = "7.2", forRemoval = true)
    private static void someOldMethod()
    {
        // ...
    }
}
