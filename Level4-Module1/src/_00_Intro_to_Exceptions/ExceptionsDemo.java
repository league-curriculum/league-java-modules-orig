package _00_Intro_to_Exceptions;

public class ExceptionsDemo {

    /*
     * Exceptions make it easier to debug or handle unexpected run time errors
     * when they arise in your programs.
     */

    /*
     * The throws keyword in testFiveOrGreater lets the compiler know this
     * method could throw a method and needs a try catch block to handle it.
     */
    public static void testFiveOrGreater(int x) throws Exception {
        if (x < 5) {
            // This is where the Exception is actually thrown.
            throw new Exception();
        }
    }

    public static void main(String[] args) {

        // 1. Create a try/catch block (Hint: type "try" and ctrl + space).

        /*
         * 2. Call the testFiveOrGreater method with a value less than 5 inside
         * the try block.
         */

        /*
         * 3. Call e.printStackTrace() in the catch block. This prints out the
         * last methods called during your program's execution to the console in
         * red text.
         */

        // 4. Run the program. Did the stack trace print out?

    }

    /*
     * 5. Create your own exception by making a new class called
     * NegativeNumberException that extends Exception.
     * 
     * 6. Add a method to your exception called scaryPopup that creates a
     * JOptionPane Message Dialog telling the user they have triggered a
     * critical error in their computer.
     */

    /*
     * 7. Create a static method in this class called testPositive. It should
     * take a single number as a parameter and throw a NegativeNumberException
     * if that number is negative.
     * 
     * 8. Call the testPositive method with a negative number inside of a the
     * main method. Make sure your catch block can catch a
     * NegativeNumberException.
     * 
     * Hint: You can add multiple catch blocks that each catch a unique
     * Exception.
     * 
     * The top Exception should be the most specific and the bottom should be
     * the most general like when using if/else if/else statements.
     * 
     * In this case, NegativeNumberException is the most specific one since it
     * extends from Exception which is capable of catching any exception.
     * 
     * 9. When the NegativeNumberException is caught, use the caught exception
     * to call your scaryPopup method.
     * 
     * 10. Try running the program. Did it show a pop-up?
     */

    /*
     * 11. Add a finally block after your catch block(Hint: finally{}). A
     * finally block always occurs after a try/catch block even if no exception
     * occurs.
     * 
     * 12. In your finally block create a JoptionPane Message Dialog that
     * assures the user their computer is okay.
     * 
     * 13. Try running the program with values that both throw and don't throw
     * exceptions.
     */
}
