package ch6_jvm;

import java.lang.Runtime.Version;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class VersionExample
{
    public static void main(final String[] args)
    {
        final Version version = Runtime.version();
        System.out.println("Reported by runtime: " + version);
        final Version v1 = Version.parse("9-ea+146-OptInfo");
        final Version v2 = Version.parse("9.1.2.1");
        printVersionInfos(v1);
        printVersionInfos(v2);
    }

    private static void printVersionInfos(final Version version)
    {
        System.out.println(version.major());
        System.out.println(version.minor());
        System.out.println(version.security());
        System.out.println(version.build());
        System.out.println(version.pre());
        System.out.println(version.optional());
    }
}
