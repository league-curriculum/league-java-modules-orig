package _02_Intro_to_Switch_Statements;

import java.util.Random;

public class SwitchStatementDemo {
    public static void main(String[] args) {

        /*
         * A Switch Statement is an alternative to writing an if else statement.
         * The following two blocks of code are logically the same.
         */

        int x = new Random().nextInt(3);

        if (x == 0) {
            System.out.println("0 from if-else");
        } else if (x == 1) {
            System.out.println("1 from if-else");
        } else if (x == 2) {
            System.out.println("2 from if-else");
        } else {
            System.out.println("Something went wrong from if-else :(");
        }

        switch (x) {

        case 0:
            System.out.println("0 from switch");
            break;
        case 1:
            System.out.println("1 from switch");
            break;
        case 2:
            System.out.println("2 from switch");
            break;
        default:
            System.out.println("Something went wrong from switch :(");
            break;

        }

        /*
         * 1. Try running the program a few times and follow the results in the
         * console.
         */

        /*
         * Switch statements are more efficient than if else statements, but are
         * subject to more restrictions.
         * 
         * They only work when comparing one value and that value must be byte,
         * short, char, int, String, enum(explained in next section), or wrapper
         * classes for the previously mentioned primitive types(Byte, Short,
         * Character, Integer).
         * 
         * Each case is a specific value that is of the same type as the value
         * you're comparing.
         * 
         * default is a catch-all case similar to else that will only occur if
         * no other cases match.
         */

        // 2. Remove the break; statements in the switch statment and run it a
        // few more times.

        /*
         * If x is 2 or lower you will notice the output has multiple results
         * for the switch statement.
         * 
         * Placing breaks after each case prevents it from falling through to
         * the cases below it.
         * 
         * This fall through property could potentially be useful if you want
         * multiple results to occur from a single comparison.
         */
    }
}
