package _00_Intro_To_Recursion;

public class _03_RecursionMath {

    public static int recursiveMultiplication(int number, int times) {
        // If times is 1 
            // Return number 

        // Else return number + recursionMultiplication(number, times-1)

        if( times==1 ) {
            return number;
        }
        
        // Multiplication as a loop of addition
        return number + recursiveMultiplication(number, times - 1);
    }
    
    // Try this one on your own! 
    // Hint: if numberToDivideBy is bigger than number,
    //       you can't divide anymore
    public static int recursiveDivision(int number, int numberToDevideBy) {
        if( numberToDevideBy > number ) {
            return 0;
        }

        // Division as a loop of subtraction
        return 1 + recurDiv( number - numberToDevideBy, numberToDevideBy );
    }

    // Try this one on your own!
    public static int recursivePower(int number, int power) {
        if( power == 0 ) {
            return 1;
        }
        
        // Power as a loop of multiplication
        return number * recursivePower(number, power - 1);
    }
}
