package _02_AND_OR_and_XOR;

/*
 * Goal: Learn about the ~, &, |, and ^ operators
 * 
 * The ~ operator is the bitwise complement operator. It inverts the bit values
 * of the binary number.
 *      0 0 0 0 0 1 1 1     // original value of 7
 *      1 1 1 1 1 0 0 0     // all bits inverted, new value of -8
 * 
 * The & operator is the bitwise AND operator. Both values must be 1 for the
 * outcome to be 1, otherwise 0.
 * Here is the output for two binary values that are & together.
 *      0 & 0 -> 0
 *      0 & 1 -> 0
 *      1 & 0 -> 0
 *      1 & 1 -> 1
 * 
 * An example,
 *      0 1 0 1     // 5 decimal
 *    & 1 0 0 1     // 9 decimal
 *    ---------
 *      0 0 0 1     // 1 dceimal. Since the rightmost column (ones column) is
 *                  // the only column that both have a 1, the result is 1.
 * 
 * The | operator is the bitwise OR operator. If any value is 1 the outcome
 * is 1, otherwise 0.
 *      0 & 0 -> 0
 *      0 & 1 -> 1
 *      1 & 0 -> 1
 *      1 & 1 -> 1
 * 
 * An example,
 *      0 1 0 1     // 5 decimal
 *    & 1 0 0 1     // 9 decimal
 *    ---------
 *      1 1 0 1     // 13 decimal. If there is a 1 in any column, it produces
 *                  // a 1 in the same column in the result.
 * 
 * The ^ operator is the Exclusive OR (XOR) operator. If both the values are
 * the same the outcome is 0, otherwise 1.
 *      0 & 0 -> 0
 *      0 & 1 -> 1
 *      1 & 0 -> 1
 *      1 & 1 -> 0
 * 
 * An example,
 *      0 1 0 1     // 5 decimal
 *    ^ 1 0 0 1     // 9 decimal
 *    ---------
 *      1 1 0 0     // 12 decimal. If there are two 1s or 0s in a column,
 *                  // the result is 0.
 */
public class _01_IntroToAndOrXorNot {
    public static void main(String[] args) {
        int num = 5 & 9;
        System.out.println("5 & 9 = " + num);

        num = 5 | 9;
        System.out.println("5 | 9 = " + num);

        num = 5 ^ 9;
        System.out.println("5 ^ 9 = " + num);

        num = ~7 & 0b11111111;
        System.out.println("~7 & 0b11111111 = " + num + "(" + Integer.toBinaryString(num) + ")");
        
        /*
         * Using the | operator to set a bit
         * Putting a '1' in mask will result in that bit being 1
         */
        num = 0b00000011;           //   3 decimal. bit 0 and 1 set
        int mask = 0b11000000;      // -64 decimal. bit 6 and 7 set
        int result = (num | mask);
        System.out.println();
        System.out.println("  00000011");
        System.out.println("| 11000000");
        System.out.println("----------");
        System.out.println("  " + Integer.toBinaryString(result) + " (" + result + ")");
        
        /*
         * Using the & operator to clear a bit
         * Putting a '0' in mask will result in that bit being 0
         */
        num = 0b01100100;           // 100 decimal. bit 5 and 6 set
        mask = 0b11111011;          //  -5 decimal. bit 2 cleared
        result = (num & mask);
        System.out.println();
        System.out.println("  01100100");
        System.out.println("& 11111011");
        System.out.println("----------");
        System.out.println("  " + String.format("%8s", Integer.toBinaryString(result)).replace(' ', '0') + " (" + result + ")");
        
        /*
         * Using the ^ operator to toggle a bit
         * Putting a '1' in mask will result in that bit being inverted (1 -> 0, and 0 -> 1)
         * Putting a '0' in mask will keep that bit the same
         */
        num = 0b00000011;           //   3 decimal. bit 0 and 1 set
        mask = 0b11000001;          // -63 decimal. bit 6, 7 and 0 set
        result = (num ^ mask);
        System.out.println();
        System.out.println("  00000011");
        System.out.println("^ 11000001");
        System.out.println("----------");
        System.out.println("  " + Integer.toBinaryString(result) + " (" + result + ")");
    }
}
