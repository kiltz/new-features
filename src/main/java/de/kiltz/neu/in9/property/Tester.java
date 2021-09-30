package de.kiltz.neu.in9.property;

public class Tester {
    
	public static void main(String[] argv) {
		Counter counter = new Counter(0);
		
		new CounterView("CounterView1", counter);
		new CounterView("CounterView2", counter);
	}
}
