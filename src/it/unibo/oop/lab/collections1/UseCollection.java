package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

	private static final int START = 1000;
	private static final int END = 2000;
	private static final int NUM_TEST_WRITING = 100000;
	private static final int NUM_TEST_READING = 1000;
	private static final int TO_MS = 1_000_000;
	
    private static final long AFRICA_POPULATION = 1_110_635_000L;
    private static final long AMERICAS_POPULATION = 972_005_000L;
    private static final long ANTARCTICA_POPULATION = 0L;
    private static final long ASIA_POPULATION = 4_298_723_000L;
    private static final long EUROPE_POPULATION = 742_452_000L;
    private static final long OCEANIA_POPULATION = 38_304_000L;
    
    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	final List<Integer> array = new ArrayList<Integer>();
        for (int i = START; i < END; i++) {
            array.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> second_array = new LinkedList<Integer>(array);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int first = array.get(0);
        array.set(array.size() - 1, first);
        array.set(0, array.get(array.size() - 1));
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(final int i : array) {
        	System.out.println(i);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long timeAr = System.nanoTime();
        for(int i = 0; i < NUM_TEST_WRITING; i++) {
        	 array.add(0, 0);
        }
        timeAr = System.nanoTime() - timeAr;
        
        long timeLi = System.nanoTime();
        for(int i = 0; i < NUM_TEST_WRITING; i++) {
        	second_array.add(0, 0);
        }
        timeLi = System.nanoTime() - timeLi;
        
        System.out.println("Writing ArrayList time: " + timeAr/TO_MS + "ms");
        System.out.println("Writing LinkedList time: " + timeLi/TO_MS + "ms");
        
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        
        timeAr = System.nanoTime();
        
        for(int i=0; i < NUM_TEST_READING; i++) {
        	array.get(array.size()/2);
        }
        
        timeAr = System.nanoTime() - timeAr;
        
        timeLi = System.nanoTime();
        
        for(int i=0; i < NUM_TEST_READING; i++) {
        	second_array.get(second_array.size()/2);
        }
        
        timeLi = System.nanoTime() - timeLi;
        
        System.out.println("Reading ArrayList time: " + timeAr/TO_MS + "ms");
        System.out.println("Reading LinkedList time: " + timeLi/TO_MS + "ms");
        
        
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        
        final Map<String, Long> population = new HashMap<>();
        
        population.put("Africa", AFRICA_POPULATION);
        population.put("Americas", AMERICAS_POPULATION);
        population.put("Antarctica", ANTARCTICA_POPULATION);
        population.put("Asia", ASIA_POPULATION);
        population.put("Europe", EUROPE_POPULATION);
        population.put("Oceania", OCEANIA_POPULATION);
        
        long totalPopulation = 0;
        for(Entry<String, Long> e : population.entrySet()) {
        	totalPopulation += e.getValue();
        }
        
        System.out.println("Total population : " + totalPopulation);
        
        /*
         * 8) Compute the population of the world
         */
    }
}
