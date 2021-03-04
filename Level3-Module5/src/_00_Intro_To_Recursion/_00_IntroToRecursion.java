package _00_Intro_To_Recursion;

public class _00_IntroToRecursion {
    /*
     * Recursion Basics:
     * Recursion is a method calling it self over and over instead of using loops.
     * The cycle starts when the method is originally called.
     * 
     * countDown(5);
     * 
     * This method, in its return statement then calls its self again restarting the cycle.
     * 
     * return countDown(5-1); ---> countDown(4);
     * 
     * The full cycle of countDown(5);
     *  return countDown(4)
     *      return countDown(3)
     *          return countDown(2)
     *              return countDown(1)
     *                  return countDown(0)
     *                      return 0; The cycle ends here because the original method isn't called again.
     */

    public static int countDown(int num) {
        System.out.println("Count Down: " + num);
        
        // Checks if the num passed in is zero.
        if(num <= 0) {
            System.out.println("STOP!");
            
            // Breaks the recursion by returning 0 instead of the method.
            return 0;
        } else {
            // When num != 0 the method calls its self but passes in a value that
            // is 1 less.
            return countDown(num-1);
        }
    }

    public static void main(String[] args) {
        countDown(5);
    }
}
