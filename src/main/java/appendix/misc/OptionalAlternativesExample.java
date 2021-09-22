package appendix.misc;

import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

/**
 * Beispielprogram für die Klasse Optional<T>.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class OptionalAlternativesExample
{
    public static void main(final String[] args) 
    {
        // Minimum für leeren Eingabe-Stream ermitteln 
        final OptionalInt min = IntStream.empty().min();
            
        // Führe Aktion aus, wenn vorhanden }$
        min.ifPresent(System.out::println);
        
        // Alternativen Wert liefern, wenn nicht vorhanden 
        System.out.println(min.orElse(-1));
        
        // Berechne Ersatzwert, wenn nicht vorhanden 
        final IntSupplier randomGenerator = () -> (int)(100 * Math.random());
        System.out.println(min.orElseGet(randomGenerator));
    
        // Löse eine Exception aus, wenn nicht vorhanden 
        min.orElseThrow(() -> new NoSuchElementException("there is no minimum"));
    }
}
