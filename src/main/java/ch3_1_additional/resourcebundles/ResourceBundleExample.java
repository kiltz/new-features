package ch3_1_additional.resourcebundles;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ResourceBundleExample
{
    private static final String BUNDLE_PATH = "ch3_1_additional.resourcebundles.text_utf8";

    public static void main(final String[] args) throws IOException
    {
       processWithProperties();    
        
       processWithResourceBundle();

       processWithSpecialUtf8ResourceBundle();
    }

    private static void processWithProperties() throws UnsupportedEncodingException,
                                                       IOException
    {
       final Properties props = readResourceBundleAsProperties();
       
       System.out.println("Properties");
       props.forEach((key,val)->System.out.println("(" + key + "," + val + ")"));
    }

    private static void processWithResourceBundle()
    {
       final ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_PATH);
       
       System.out.println("\nResourceBundle");
       printContents(bundle);
    }

    private static void processWithSpecialUtf8ResourceBundle()
    {
       final ResourceBundle utf8Bundle = 
             Utf8PropertyResourceBundle.getUtf8Bundle(BUNDLE_PATH);
             
       System.out.println("\nUtf8PropertyResourceBundle");
       printContents(utf8Bundle);
    }

    private static Properties readResourceBundleAsProperties() throws
                              UnsupportedEncodingException, 
                              IOException
    {
       try (final InputStream utf8in = ResourceBundleExample.class.
                                       getResourceAsStream("text_utf8.properties");
            final Reader reader = new InputStreamReader(utf8in, "UTF-8"))
       {
          final Properties props = new Properties();
          props.load(reader);
          return props;
       }
    }

    private static void printContents(final ResourceBundle bundle)
    {
       bundle.keySet().forEach(key -> System.out.println("("+key+"," + 
                                                      bundle.getString(key)+")"));
    }
}
