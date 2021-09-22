package ch8_java12;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesMismatch 
{
    public static void main(String[] args) throws IOException 
    {
        compareSameContent();
        compareDifferentContent();                
        compareDifferentEncodings();                
        checkSameFile();     
     }

private static void compareSameContent() throws IOException 
{
	Path filePath1 = Files.createTempFile("test1", ".txt");
    Path filePath2 = Files.createTempFile("test2", ".txt");
    
    Files.writeString(filePath1, "Same Content");
    Files.writeString(filePath2, "Same Content");

    long mismatchPos1 = Files.mismatch(filePath1, filePath2);
    System.out.println("Same content: mismatch(File1, File2) = " + mismatchPos1); 
}

private static void compareDifferentContent() throws IOException 
{
	Path filePath1 = Files.createTempFile("test1", ".txt");
    Path filePath2 = Files.createTempFile("test2", ".txt");
    
    Files.writeString(filePath1, "Same Content");
    Files.writeString(filePath2, "Same Start / Different Content");
    
    long mismatchPos2 = Files.mismatch(filePath1, filePath2);
    System.out.println("Different content: mismatch(File1, File2) = " + mismatchPos2);
}

	
private static void compareDifferentEncodings() throws IOException 
{
	var fileLatin1 = Files.createTempFile("enc1", ".latin1");
	var fileUtf8 = Files.createTempFile("enc2", ".utf8");
    
    var msg = "Zürich is beautiful. Mainz too";
    Files.writeString(fileLatin1, msg, StandardCharsets.ISO_8859_1);
    Files.writeString(fileUtf8, msg, StandardCharsets.UTF_8);

    var pos = Files.mismatch(fileLatin1, fileUtf8);
    System.out.println("Different encoding: mismatch(File1, File2) = " + pos);
}

	private static void checkSameFile() throws IOException 
	{	
		var oneFile = Files.createTempFile("oneFile", ".txt");
		
		var mismatchPosSameFile = Files.mismatch(oneFile, oneFile);
		
        System.out.println("oneFile mismatch oneFile = " + mismatchPosSameFile);
	}
}