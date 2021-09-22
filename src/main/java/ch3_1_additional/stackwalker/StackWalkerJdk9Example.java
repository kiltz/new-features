package ch3_1_additional.stackwalker;

import java.lang.StackWalker.StackFrame;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class StackWalkerJdk9Example
{
    public static void main(final String[] args)
    {
        first();
    }

    private static void first()
    {
        second();
    }

    private static void second()
    {
        final List<String> stackframes = provideStackframesJdk9();
        stackframes.forEach(System.out::println);
    }

    private static List<String> provideStackframesJdk9()
    {
        return StackWalker.getInstance().walk(extractClassMethodAndLineNumber());
    }

    private static Function<Stream<StackFrame>, List<String>> 
                                                extractClassMethodAndLineNumber()
    {
        final Predicate<String> isJdk9Example = name -> name.startsWith("ch3_1_5");
        return stream -> stream.map(frame -> frame.getClassName() + "/" +
                                             frame.getMethodName() + "@line:" + 
                                             frame.getLineNumber())
                               .filter(isJdk9Example)                        
                               .collect(Collectors.toList());
    }
}
