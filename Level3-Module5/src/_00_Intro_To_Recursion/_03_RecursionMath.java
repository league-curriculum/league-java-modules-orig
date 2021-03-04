package _00_Intro_To_Recursion;

public class _03_RecursionMath {

    public static int recursiveMultiplication(int number, int times) {
        // If times is 1 
            // Return number 

        // Else return number + recursionMultiplication(number, times-1)

        if(times==1) {
            return number;
        } else {
            return number + recursiveMultiplication(number, times-1);
        }
    }
    
    // Try this one on your own! 
    // Hint: if numberToDivideBy is bigger than number,
    //       you can't divide anymore
    public static int recursiveDivision(int number, int numberToDevideBy) {
        
        return 0;
    }

    // Try this one on your own!
    public static int recursivePower(int number, int power) {
        
        return 0;
    }
}
