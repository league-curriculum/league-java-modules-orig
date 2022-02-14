package _02_Intro_To_Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/*
 * Java supports an alternate way to modify and operate on Collections,
 * e.g. Arrays, ArrayLists, HashMaps, etc. using the Stream interface.
 * 
 * Using Stream methods allows Java to potentially be more efficient with how
 * the operation is done. Here is an example:
 *   String[] words = {"These", "are", "some", "words!!!"};
 * 
 *   // 1. Using a for loop for iteration
 *   for (String word : words) {
 *       System.out.println(word);
 *   }
 * 
 *   // 2. Using streams for iteration
 *   Arrays.stream(words).forEach((word) -> System.out.println(word));
 * 
 * Both approaches print all the words in the string array. The difference is
 * the for loop explicitly tells Java how to iterate through the collection.
 * The stream approach lets Java determine the best way to iterate through the
 * Array and potentially use ways to split up the print tasks to make the
 * procedure faster and more efficient.
 * 
 * Certain stream methods operate on the collection and return a stream with
 * the changes, similar to how string methods return a new string. Here is an
 * example that counts the total number of characters of strings larger than 4:
 *   int totalCharacters = Arrays
 *                          .stream(words)                          // 1.
 *                          .filter((word) -> word.length() > 4)    // 2.
 *                          .map((word) -> word.length())           // 3.
 *                          .reduce(0, (acc, next) -> acc + next);  // 4.
 *   1. Create stream from string array
 *   2. Only keep words with more than 4 characters in the stream
 *   3. Create a stream of ints from a stream of strings
 *   4. Return the sum of all the ints in the stream
 *      acc is the running sum of the ints as they're added
 *      0 is the initial value put into acc
 *      next is the next int in the stream
 *
 * filter() and map() both return a stream so the methods can be called right
 * afterwards. reduce() returns an int and closes the stream so it must be
 * called at the very end of a series of stream operations.
 * 
 * Below are examples of common stream methods.
 */
public class IntroToStreams {
    
    public static void main(String[] args) {
        class Car {
            String make;
            int mileage;
            
            Car(String make, int mileage){
                this.make = make;
                this.mileage = mileage;
            }
        }
        
        /*
         * How to create streams from different Collections
         */
        String[] strArr = {"one", "two", "three", "four"};
        Stream<String> arrStream = Arrays.stream(strArr);

        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(-2);
        intList.add(3);
        Stream<Integer> listStream = intList.stream();

        List<Car> carList = new LinkedList<Car>();
        carList.add(new Car("Honda", 200000));
        carList.add(new Car("Ford", 60000));
        carList.add(new Car("Ferarri", 10000));
        Stream<Car> carListStream = carList.stream();

        // Stream of 100 random (primitive) double values from 50 to 200
        DoubleStream dblStream = new Random().doubles(100, 50, 200);
        
        /*
         * forEach() - Apply operation to all elements
         */
        System.out.print("Array stream forEach(): ");
        Arrays.stream(strArr).forEach( (word) -> System.out.print(word + " ") );
        
        System.out.print("\nList stream forEach(): ");
        intList.stream().forEach( (i) -> System.out.print(i + " ") );
        
        /*
         * sorted() - Sort elements in natural order
         */
        System.out.println();
        System.out.print("\nArray stream sorted(): ");
        Arrays.stream(strArr).sorted().forEach((word) -> System.out.print(word + " "));
        
        System.out.print("\nList stream sorted(): ");
        intList.stream().sorted().forEach((i) -> System.out.print(i + " " ));
        
        /*
         * sorted((e)-> comparator) - Sort based on specific criteria
         */
        System.out.println();
        System.out.println("\nList sorted alphabetically by car name: ");
        carList.stream().sorted((car1, car2) -> car1.make.compareTo(car2.make))
                         .forEach((car) -> System.out.print(car.make + " "));
        
        System.out.println();
        System.out.println("\nList sorted from highest mileage to lowest: ");
        carList.stream().sorted((car1, car2) -> car2.mileage - car1.mileage)
                         .forEach((car) -> System.out.println(car.make + " " + car.mileage));
        
        /*
         * Convert Array to List
         * boxed - convert stream of double (primitive) to Double (Object)
         * collect(Collectors.toList()) - add stream elements to list and return
         */
        List<Double> dblObjList = new Random()
                                    .doubles(5, 0, 10)
                                    .boxed()
                                    .collect(Collectors.toList());
        System.out.println("\nStream of double values to List of Double objects:");
        System.out.println(dblObjList);
        
        /*
         * Convert List to array
         * toArray() - convert stream of objects to an array
         */
        Integer[] integerArr = intList.stream()
                                      .toArray((streamSize)->new Integer[streamSize]);
        System.out.println("\nStream of Integer objects to an array of Integer objects");
        System.out.println(Arrays.toString(integerArr));
        
        /*
         * Add/remove elements in stream based on condition
         * filter((e) -> condition) - keep items that return true for condition
         * count() - return number of items in the stream
         */
        long count = Arrays.stream(strArr)
                           .filter((word) -> word.contains("e"))
                           .count();
        System.out.println("\nNumber of words that contain the letter 'e': " + count);
        System.out.println(Arrays.toString(strArr));
        
        /*
         * Combine elements into single value
         * reduce(initalValue, (accumulator, next) -> combine)
         */
        int totalMileage = intList.stream().reduce(0, (acc, next) -> {
            return acc + next;
        });
        System.out.println("\nSum of all ints in list: " + totalMileage);
        System.out.println(intList);
        
        /*
         * Scale or convert a stream of elements to another
         * map((e) -> a new element)
         */
        List<String> models = carList.stream()
                                      .map((car) -> car.make)
                                      .collect(Collectors.toList());
        System.out.println("\nMap list of cars to list of strings: " + models);
        
        /*
         * Stream method chaining, filter, map, and reduce
         */
        int totalCharacters = Arrays.stream(strArr)
                                    .filter( (word) -> word.length() > 3 )
                                    .map( (word) -> word.length() )
                                    .reduce( 0, (acc, next) -> acc+ next);
        
        System.out.println("\nThe total number of characters for words"
                + " longer than 3 characters is: " + totalCharacters);
        System.out.println(Arrays.toString(strArr));
        
        /*
         * Sort and remove duplicates in an array
         */
        double[] data = {1.1, 1.1, 2.9, 55.2, -12.0, 2.9, 98.6, 77.7, 55.2, -459.5, 1.1};
        double[] sorted = Arrays.stream(data)
                                .distinct()
                                .sorted()
                                .toArray();
                                
        System.out.println("\nSort array and remove duplicates:");
        System.out.println(Arrays.toString(data));
        System.out.println(Arrays.toString(sorted));
        
        System.out.println();
        System.out.println("Min val: " + Arrays.stream(sorted).min().getAsDouble());
        System.out.println("Max val: " + Arrays.stream(sorted).max().getAsDouble());
        System.out.println("Sum ...: " + Arrays.stream(sorted).sum());
        System.out.println("Average: " + Arrays.stream(sorted).average().getAsDouble());
        System.out.println("Summary: " + Arrays.stream(sorted).summaryStatistics());
    }
}
