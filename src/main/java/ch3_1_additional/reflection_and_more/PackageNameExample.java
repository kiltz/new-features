package ch3_1_additional.reflection_and_more;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class PackageNameExample
{
    public static void main(final String[] args)
    {
        System.out.println(getPackageNameJDK8(PackageNameExample.class));
        System.out.println(PackageNameExample.class.getPackageName());
    }

    private static <T> String getPackageNameJDK8(final Class<T> clazz)
    {
        final String fullyQualifiedClassname = clazz.getCanonicalName();
        final int lastDot = fullyQualifiedClassname.lastIndexOf(".");
        return fullyQualifiedClassname.substring(0, lastDot);
    }

    private static <T> String getPackageNameJDK8_2(final Class<T> clazz)
    {
        return clazz.getPackage().getName();
    }
}
