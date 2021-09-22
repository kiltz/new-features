package ch12_3_2;

import java.lang.module.Configuration;
import java.lang.module.ResolvedModule;
import java.lang.ModuleLayer;
import java.lang.Module;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ModuleForClassFinder
{
    public static void main(final String[] args) throws ClassNotFoundException
    {
        final List<String> classNames = List.of("java.util.logging.Logger", 
                                                "java.time.LocalDate",
                                                "javax.swing.JFrame");

        final Set<String> jdkModules = new TreeSet<>();

        for (final String className : classNames)
        {
            final Optional<ResolvedModule> optModule = findModuleByName(className);
            optModule.ifPresent(mod -> jdkModules.add(mod.name()));
        }

        System.out.println("Classes: " + classNames);
        System.out.println("Modules: " + jdkModules);
    }

    private static Optional<ResolvedModule> findModuleByName(final String className)
    {
        final Configuration config = ModuleLayer.boot().configuration();
        final Set<ResolvedModule> modules = config.modules();

        return modules.stream().filter(module -> tryFindClass(module, className)).findFirst();
    }

    public static boolean tryFindClass(final ResolvedModule resModule, final String name)
    {
        final Optional<Module> optModule = ModuleLayer.boot().findModule(resModule.name());
        if (optModule.isPresent())
        {
            final Module module = optModule.get();
            final Class<?> clazz = Class.forName(module, name);
            return clazz != null;
        }
        return false;
    }
}
