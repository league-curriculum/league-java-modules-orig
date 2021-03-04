package _01_IntroToQueues;

import java.util.ArrayDeque;

public class _00_QueueDemo {
    public static void main(String[] args) {

        /*
         * A Queue is a data structure that maintains the order of the objects
         * added to it. It's similar to a Stack except the Queue removes
         * the "oldest" object first instead of the "newest" object.
         * For example, if 3 String objects are added to a Queue,
         * ArrayDeque<String> myQueue = new ArrayDeque<String>();
         * myQueue.add("A");    // oldest object added
         * myQueue.add("B");
         * myQueue.add("C");    // newest object added
         * myQueue.remove()     // returns "A" and the Queue size is decreased by 1 
         * the String "A" is removed when the remove() method is called.
         * 
         * The oldest object added to a Queue is called the 'front' or 'head'
         * of the Queue. The most recent object added to a Queue is called the
         * "back" or "tail" of the Queue. Similar to a Stack, adding and
         * removing objects from the middle of a Queue is not allowed. This
         * maintains the order of the Queue where the first object added is the
         * first object out of the Queue. This ordering is called First In
         * First Out, or FIFO for short.
         *      add to back+           +front (next to be removed)
         *                 |           |
         *                  "C" "B" "A"
         */
        
        /*
         * Initializing a Queue of Strings
         */
        System.out.println("Here is a Queue of Strings: \n");

        ArrayDeque<String> lineToEnter = new ArrayDeque<String>();
        lineToEnter.add("Jerry");
        lineToEnter.add("Mary");
        lineToEnter.add("Javier");
        lineToEnter.add("Irina");
        lineToEnter.add("Rosemary");
        lineToEnter.add("Arthur");

        /*
         * The first person added to the Queue, Jerry, will be the first person
         * removed, followed by second person added, third person, etc.
         * The remove() method reduces the size of the Queue by 1
         */
        System.out.println("Queue size: " + lineToEnter.size());
        System.out.println("Removing the front of the Queue:");
        System.out.println(lineToEnter.remove());

        /*
         * Getting the size of the Queue
         * Notice the size is smaller by 1 after the remove() method
         */
        System.out.println("Queue size: " + lineToEnter.size());
        
        /*
         * Looping through the Queue and clearing it
         */
        System.out.println("\nRemoving all the Strings off the Queue:");
        while( ! lineToEnter.isEmpty() ) {
            System.out.println(lineToEnter.remove());
        }
        
        System.out.println("Queue size: " + lineToEnter.size());
    }
}
