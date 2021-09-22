package ch3_1_additional.reflection_and_more;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class VarHandleExample
{
    private int          x            = 0;

    private final String readOnlyText = "I Am Read Only";

    public static void main(final String[] args) throws Throwable
    {
        // Auslesen der VarHandle-Informationen
        final VarHandle varHandleX = getVarHandle(VarHandleExample.class, "x", int.class);
        printVarHandleInfo(varHandleX);

        final VarHandle varHandleText = getVarHandle(VarHandleExample.class, "readOnlyText", String.class);
        printVarHandleInfo(varHandleText);

        // Aktionen auf Variable x 
        final VarHandleExample instance = new VarHandleExample();
        varHandleX.getAndAdd(instance, 1);
        System.out.println(instance.x);

        varHandleX.set(instance, 14);
        System.out.println(varHandleX.get(instance));

        // Exception in thread "main" java.lang.UnsupportedOperationException
        varHandleText.set(instance, "Not supported");
    }

    private static VarHandle getVarHandle(final Class<?> clazz, final String name, final Class<?> paramType)
                    throws Exception
    {
        return MethodHandles.lookup().in(clazz).findVarHandle(clazz, name, paramType);
    }

    private static void printVarHandleInfo(final VarHandle vh)
    {
        System.out.println("VarHandle: " + vh);
        System.out.println("Type: " + vh.varType());
    }
}