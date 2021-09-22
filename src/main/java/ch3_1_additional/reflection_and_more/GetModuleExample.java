package ch3_1_additional.reflection_and_more;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class GetModuleExample
{
    public static void main(final String[] args) throws ClassNotFoundException
    {
        final Class<?> clazz = Class.forName("java.util.logging.Logger");
        System.out.println(clazz.getModule());

        final Class<?> clazz2 = Class.forName("javafx.application.Application");
        System.out.println(clazz2.getModule());

        final Class<?> clazz3 = Class.forName("javafx.scene.control.ScrollPane");
        System.out.println(clazz3.getModule());
    }
}
