package ch3_1_additional.resourcebundles;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class Utf8PropertyResourceBundle extends ResourceBundle
{
    private final PropertyResourceBundle bundle;

    public static final ResourceBundle getUtf8Bundle(final String baseName)
    {
        final ResourceBundle bundle = ResourceBundle.getBundle(baseName);
        if (!(bundle instanceof PropertyResourceBundle))
        {
            return bundle;
        }
        return new Utf8PropertyResourceBundle((PropertyResourceBundle) bundle);
    }

    private Utf8PropertyResourceBundle(final PropertyResourceBundle bundle)
    {
        this.bundle = bundle;
    }

    @Override
    public Enumeration<String> getKeys()
    {
        return bundle.getKeys();
    }

    @Override
    protected Object handleGetObject(final String key)
    {
        final String value = bundle.getString(key);
        
        return value == null ? null :convertString(value);
    }

    private Object convertString(final String value)
    {
        try
        {
            return new String(value.getBytes("ISO-8859-1"), "UTF-8");
            //return new String(value.getBytes("UTF-8"), "UTF-8");
        }
        catch (final UnsupportedEncodingException e)
        {
            throw new RuntimeException("Encoding not supported", e);
        }
    }
}