package ch9_java13_14;

import java.time.LocalDate;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 14"
 * 
 * @author Michael Inden
 * 
 * Copyright 2020 by Michael Inden 
 */
public class TextBlockExample
{
    public static void main(String[] args)
    {
        String placeholders = """
                        Michael %s hat am "%tF"
                        %d Bücher in ’%s’ gekauft.
                        """.formatted("Inden", LocalDate.of(2020, 1, 20), 7, "Bremen");

        String javaScriptCode = """
                        function hello() {
                            print("Hello World");
                        }
                        hello();
                        """;

        System.out.println(placeholders);
        System.out.println(javaScriptCode);
    }
}
