package _01_IntroToQueues;

import java.util.ArrayDeque;
import java.util.Random;
import java.util.Stack;

public class _01_IntroToQueue {
    public static void main(String[] args) {
        // 1. Create a Stack of Doubles using the Stack class
        Stack<Double> doubles = new Stack<>();
        // 2. Use a loop to add 100 random doubles between 0 and 100 to the Stack
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            doubles.push(rand.nextDouble() * 100);
        }

        // 3. Create a Queue of Doubles using the ArrayDeque class
        ArrayDeque<Double> queue = new ArrayDeque<>();

        // 4. Pop off 5 elements from the Stack and add them to the Queue
        int num = 0;
        while (num++ < 5) {
            queue.add(doubles.pop());
        }

        while (!doubles.isEmpty() || !queue.isEmpty()) {
            System.out.println("Queue size: " + queue.size() + ", stack size: " + doubles.size() );
            
            // 5. Print and remove a random number of elements, from 1 to 5 elements,
            // from the front of the Queue. Example:
            // "removing 3 elements from Queue: 25 57 2"
            num = 0;
            int numTimes = rand.nextInt(4) + 1;
            String str = "removing " + numTimes + " elements from Queue: ";
            while (num++ < numTimes) {
                str += queue.remove() + " ";
            }
            System.out.println(str);

            // 6. Pop off as many elements from the stack to fill the Queue with 5
            // elements. If there aren't enough elements in the Stack to fill the
            // queue, fill the queue as much as possible.
            while (queue.size() < 5) {
                if (doubles.size() <= 0) {
                    break;
                } else {
                    queue.add(doubles.pop());
                }
            }
            
            System.out.println();
        }
        
        System.out.println("Queue size: " + queue.size() + ", stack size: " + doubles.size() );

        // 7. Loop until there are no more elements in the Stack and Queue and all
        // the elements are printed

        /*
         * Example: stack: { ..., 60, 36, 88, 4, 65, 75, 10 } queue: { } // empty
         * 
         * Pop off 5 elements from stack to fill queue with 5 elements stack: { ..., 60,
         * 36 } queue: { 10, 75, 65, 4, 88 }
         * 
         * Remove a random number of elements from the front of the queue (2 in this
         * example) and print the number of elements being removed and the elements
         * stack: { ..., 60, 36 } queue: { 65, 4, 88 } "Removing 2 elements: 10 75"
         * 
         * Pop off 2 elements from the stack to fill the queue to 5 stack: { ... }
         * queue: { 65, 4, 88, 36, 60 }
         * 
         * Repeat until there are no more elements in the stack and queue
         */
    }
}
