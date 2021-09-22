package ch3_1_additional.reflection_and_more;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class FirstMethodHandleExample
{
    public static void main(final String[] args) throws Throwable
    {
        callSayHello();
        callSay();
    }
    
    private static void callSayHello() throws NoSuchMethodException, 
                                          IllegalAccessException, Throwable
    {
        // MethodHandle ermitteln
        final MethodHandle sayHelloHandle = MethodHandles.lookup()
                          .findVirtual(GreetingUtils.class, "sayHello", 
                           MethodType.methodType(int.class, String.class));
    
        System.out.println("MethodHandle: " + sayHelloHandle);
        final Object result = sayHelloHandle.invoke(new GreetingUtils(), "Virtual");
        System.out.println("Result: " + result);
    }
    
    private static void callSay() throws NoSuchMethodException, 
                                     IllegalAccessException, Throwable
    {
        // MethodHandle für statische Methode
        final MethodHandle sayStaticHandle = MethodHandles.lookup()
                            .findStatic(GreetingUtils.class, "say", 
                             // Achtung: void.class / Void.class
                             MethodType.methodType(void.class, String.class)); 
    
        System.out.println("MethodHandle: " + sayStaticHandle);        
        sayStaticHandle.invoke("Static Method");
    }
}
