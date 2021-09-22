package appendix.dateandtime;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Beispielprogramm zur Demonstration der Klasse Instant.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2015 by Michael Inden 
 */
public class InstantExample 
{
	public static void main(final String[] args) 
	{
	    // Abfahrt 12:30 und Reisedauer 5 Stunden  
	    final Instant departureTime = Instant.parse("2015-02-07T12:30:00Z");
	    final Instant expectedArrivalTime = departureTime.plus(5, ChronoUnit.HOURS);

	    // Verspätung von 7 Minuten berechnen  
	    final Instant arrival = expectedArrivalTime.plus(7, ChronoUnit.MINUTES);

	    System.out.println("departure: " + departureTime);         
	    System.out.println("expected:  " + expectedArrivalTime);   
	    System.out.println("arrival:   " + arrival);   
	}
}