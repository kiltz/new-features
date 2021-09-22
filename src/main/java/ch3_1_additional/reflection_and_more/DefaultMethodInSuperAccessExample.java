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
public class DefaultMethodInSuperAccessExample
{
    public static void main(final String[] args) throws Throwable
    {
        final MethodType mType = MethodType.methodType(void.class);
        final MethodHandle mh1 = MethodHandles.lookup().findSpecial(BaseIF.class, "m", mType, BaseClass.class);
        mh1.invoke(new BaseClass());

        final MethodHandle mh2 = MethodHandles.lookup().findVirtual(BaseClass.class, "m", mType);
        mh2.invoke(new BaseClass());
    }
}

interface BaseIF
{
    default void m()
    {
        System.err.println("BaseIF.m()");
    }
}

class BaseClass implements BaseIF
{
    public void m()
    {
        System.out.println("BaseClass.m()");
    }
}