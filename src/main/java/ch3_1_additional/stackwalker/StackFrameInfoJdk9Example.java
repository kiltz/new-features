package ch3_1_additional.stackwalker;

import java.lang.StackWalker.StackFrame;
import java.util.NoSuchElementException;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class StackFrameInfoJdk9Example
{
    public static void main(final String[] args)
    {
        myMethod();
    }

    private static void myMethod()
    {
        final StackFrame callerStackFrame = getCallerFrame();

        printStackFrameInfo(callerStackFrame);
    }

    private static void printStackFrameInfo(final StackFrame stackFrame)
    {
        System.out.println("Class:  " + stackFrame.getClassName());
        System.out.println("File:   " + stackFrame.getFileName());
        System.out.println("Line:   " + stackFrame.getLineNumber());
        System.out.println("Method: " + stackFrame.getMethodName());
    }

    public static StackFrame getCallerFrame()
    {
        return StackWalker.getInstance().walk(stream -> stream.skip(2).findFirst())
                        .orElseThrow(NoSuchElementException::new);
    }
}