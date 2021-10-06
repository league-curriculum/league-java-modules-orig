package _02_Intro_To_Searching_Algorithms;

import java.util.Arrays;
import java.util.List;

public class _00_SearchingAlgorithmsDemo {
    public static void main(String[] args) {
        /*
         * Searching algorithms refer to different ways to find a specified
         * element in a data structure.
         * 
         * The searching algorithms you'll need to know are Linear Search and
         * Binary Search. Both algorithms return the index in the data
         * structure where the element is located.
         * 
         * Linear Search:
         * Looks at each element in the data structure sequentially until it
         * finds the matching element. This searching algorithm is intuitive
         * and easy to implement, but it's not very efficient as the size of
         * the data structure grows. Linear Search can work on an unsorted
         * data structure.
         * https://en.wikipedia.org/wiki/Linear_search
         * 
         * Binary Search:
         * Binary Search can only be done on a sorted data structure.
         * The algorithm compares the target element to the middle element of
         * the data structure. If they are not equal, the search continues on
         * the half where the target element may exists in the sorted data
         * structure. The search checks the middle element again and repeats
         * until the target element is found.
         * https://en.wikipedia.org/wiki/Binary_search_algorithm
         */
        
        int[] intArr = {100, 50, 25, 0, 500, 234, 12, 78, 9};
        List<Integer> intList = Arrays.asList(100, 50, 25, 0, 500, 234, 12, 78, 9);
        
        /*
         * Implementation of Linear Search on array
         */
        int targetValue = 12;
        int indexOfValue = -1;
        for( int i = 0; i < intArr.length; i++ ) {
            if( intArr[i] == targetValue ) {
                indexOfValue = i;
                break;
            }
        }
        
        System.out.println("Using Linear Search on array to find: " + targetValue + " in " + Arrays.toString(intArr));
        System.out.println(targetValue + " found at index: " + indexOfValue);
        
        /*
         * Implementation of Linear Search on ArrayList
         */
        targetValue = 12;
        indexOfValue = -1;
        for( int i = 0; i < intList.size(); i++ ) {
            if( intList.get(i) == targetValue ) {
                indexOfValue = i;
                break;
            }
        }
        
        System.out.println();
        System.out.println("Using Linear Search on list to find: " + targetValue + " in " + Arrays.toString(intList.toArray()));
        System.out.println(targetValue + " found at index: " + indexOfValue);
    }
}
