package ch12_3_3;

import java.lang.reflect.Field;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ReflectionAttributeAccessor
{
    public Object getAttributeValue(final Object object, final String attributeName)
    {
        try
        {
            final Class<?> clazz = object.getClass();
            final Field field = clazz.getDeclaredField(attributeName);

            field.setAccessible(true);

            return field.get(object);
        }
        catch (ReflectiveOperationException ex)
        {
            throw new IllegalStateException("problems while using reflection");
        }
    }
}