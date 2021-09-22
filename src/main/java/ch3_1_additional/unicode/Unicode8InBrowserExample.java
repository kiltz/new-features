package ch3_1_additional.unicode;

import java.awt.*;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class Unicode8InBrowserExample
{    
    public static void main(final String[] args) throws Exception
    {
        final File tmpFile = createInputFile();
        showInBrowser(tmpFile);
    }

    private static File createInputFile() throws IOException, FileNotFoundException
    {
        final String content = "<html><body><h1>" +
                               "Test" +
                               "&#x00B0 &#x1801 &#x25D0 &#x2A0C &#x83fb --- " +
                               "&#x1f605 &#x1f310 &#x1f575 &#x1F917" +
                               "</h1></body></html>";
    
        final File tmpFile = File.createTempFile("Unicode_8_", ".html");
        
        try (final FileOutputStream fos = new FileOutputStream(tmpFile);
             final BufferedOutputStream bos = new BufferedOutputStream(fos))
        {
              bos.write(content.getBytes());
              bos.flush();
        }
        return tmpFile;
    }

    private static void showInBrowser(final File tmpFile) throws IOException
    {
        if (Desktop.isDesktopSupported())
        {
            final Desktop desktop = Desktop.getDesktop();
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE))
            {
                desktop.browse(tmpFile.toURI());
            }
        }
    }
}
