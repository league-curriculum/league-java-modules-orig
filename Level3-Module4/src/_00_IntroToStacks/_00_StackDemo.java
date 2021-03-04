package _00_IntroToStacks;

import java.util.Stack;

public class _00_StackDemo {
    public static void main(String[] args) {
        /*
         * A Stack is a data structure that maintains the order of the objects
         * added to it. The push() method is used to add objects to a Stack
         * and the pop() method is used to remove the *most recently added*
         * object from the Stack. For example, if 3 String objects are pushed,
         * i.e. added, to a Stack
         * Stack<String> myStack = new Stack<String>();
         * myStack.push("A");    // oldest object added
         * myStack.push("B");
         * myStack.push("C");    // newest object added
         * myStack.pop()         // returns "C" 
         * the String "C" is removed when the pop() method is called. Note that
         * the size of the Stack is decreased by 1 every time pop() is called.
         * 
         * The most recent object added to a Stack is the 'top' or 'head' of
         * the Stack. Normally, adding and removing objects from the middle of
         * a Stack is not allowed. This maintains the order of the Stack where
         * the first object added is the last object out of the Stack. This
         * ordering is called First In Last Out, or FILO for short. 
         *      push on top-+    +-> next to be removed    
         *                   \  /
         *                    "C"
         *                    "B"
         *                    "A" -> first object pushed, last to be removed
         */
        
        /*
         * Initializing a Stack of Strings
         */
        System.out.println("Here is a Stack of Strings: \n");

        Stack<String> flavors = new Stack<String>();
        flavors.push("Strawberry");
        flavors.push("Mint");
        flavors.push("Chocolate");
        flavors.push("Apple");
        flavors.push("Vanilla");
        flavors.push("Mango");

        /*
         * Since Mango was the last one pushed, it will be the first one popped.
         * The pop() method reduces the size of the Stack by 1
         */
        System.out.println("Stack size: " + flavors.size());
        System.out.println("Popping off the top of the stack:");
        System.out.println(flavors.pop());

        /*
         * Getting the size of the Stack
         * Notice the size is smaller by 1 after the pop() method
         */
        System.out.println("Stack size: " + flavors.size());
        
        /*
         * Looping through the Stack and clearing it
         */
        System.out.println("\nPopping all the Strings off the Stack:");
        while( ! flavors.isEmpty() ) {
            System.out.println(flavors.pop());
        }
        
        System.out.println("Stack size: " + flavors.size());
    }
}
