package ch12_3_1;

import java.lang.module.ModuleDescriptor;
import java.util.Optional;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ModuleInspector
{
    public static void main(final String[] args) throws ClassNotFoundException
    {
        final Optional<Module> optRmiModule = ModuleLayer.boot().findModule("java.rmi");
        final Optional<Module> optLogModule = ModuleLayer.boot().findModule("java.logging");
        optLogModule.ifPresent(logModule -> 
        {
            optRmiModule.ifPresent(rmiModule -> printModuleInfo(logModule, rmiModule));

            printModuleDescriptorInfo(logModule.getDescriptor());
        });
    }

    private static void printModuleInfo(final Module module, final Module rmiModule)
    {
        System.out.println("Module: " + module);
        System.out.println("Packages: " + module.getPackages());
        System.out.println("log canRead RMI: " + module.canRead(rmiModule));
        System.out.println("RMI canRead log: " + rmiModule.canRead(module));
    }

    private static void printModuleDescriptorInfo(final ModuleDescriptor descriptor)
    {
        System.out.println("\nDescriptor: " + descriptor);
        System.out.println("\nrequires:  " + descriptor.requires());
        System.out.println("provides:  " + descriptor.provides());
        System.out.println("exports:   " + descriptor.exports());
        System.out.println("automatic: " + descriptor.isAutomatic());
        System.out.println("packages:  " + descriptor.packages());
    }
}
