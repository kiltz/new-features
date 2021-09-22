package ch5_java11;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class FilesReadNBytesExample 
{
	public static void main(String[] args) throws IOException {

        var filePath = createTempPath("test-read-n-bytes1");
        
        Files.writeString(filePath, "01234567--Content starts here");

        try (var is = new FileInputStream(filePath.toFile()))
        {
            var first10 = is.readNBytes(10);
            var next10 = is.readNBytes(10);
    
            System.out.println(Arrays.toString(first10));
            System.out.println(new String(first10));
            System.out.println("----------------------");
            System.out.println(Arrays.toString(next10));
            System.out.println(new String(next10));
        }        
    }

    static Path createTempPath(String fileName) throws IOException 
    {
        Path tempPath = Files.createTempFile(fileName, ".txt");
        tempPath.toFile().deleteOnExit();

        return tempPath;
    }
}
