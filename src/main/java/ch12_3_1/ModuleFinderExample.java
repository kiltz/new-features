package ch12_3_1;

import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.util.Comparator;
import java.util.Set;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ModuleFinderExample
{
    public static void main(final String[] args) throws ClassNotFoundException
    {
        final ModuleFinder systemFinder = ModuleFinder.ofSystem();
        final Set<ModuleReference> modules = systemFinder.findAll();
        modules.stream().sorted(Comparator.comparing(ModuleReference::descriptor))
                        .limit(5)
                        .forEach(System.out::println);
    }
}
