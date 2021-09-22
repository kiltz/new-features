package ch8_java12;

import java.util.Arrays;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class StringExample
{
    public static void main(String[] args)
    {
        // String
        // ===========
        System.out.println("------------------------------------");
        indentExample();
        indentProblem();
        indentHowItShouldBeUsed();

        System.out.println("------------------------------------");
        transformationOldStyle();

        transformationJdk12Style();
    }

    private static void transformationJdk12Style()
    {
        var text = "This is a Test";

        var result = text.transform(String::toUpperCase).
                          transform(str -> str.replaceAll("T", "")).
                          transform(str -> str.split(" "));

        System.out.println(Arrays.toString(result));
    }

    private static void transformationOldStyle()
    {
        var text = "This is a Test";
        // String.toUppercase(text)s
        // chaining of operations
        var up = text.toUpperCase();
        var noTs = up.replaceAll("T", "");
        var res = noTs.split(" ");
        System.out.println(Arrays.asList(res));
    }

    private static void indentExample()
    {
        var test = "Test".indent(4);
        printTextAndLength(test);

        var removeTest = "     6789".indent(-5);
        printTextAndLength(removeTest);
    }

    private static void printTextAndLength(final String removeTest)
    {
        System.out.println("'" + removeTest + "'");
        System.out.println(removeTest.length());
    }

    private static void indentHowItShouldBeUsed()
    {
        var header = "Report";
        var infoMessage = "This is a message\nThis is line 2\nLine3".indent(4);

        System.out.println(header);
        System.out.println(infoMessage);
    }

    // TODO: Bug report? MICHAEL
    private static void indentProblem()
    {
        var header = "Level 0: Report";
        var infoMessage = "Level 1: This is a message".indent(3); // Wieso new line? => implementation details, ugly?
        var infoMessage2 = "Level 2: This is a line 2".indent(7);

        System.out.println(header);
        System.out.println(infoMessage);
        System.out.println(infoMessage2);
    }
}
