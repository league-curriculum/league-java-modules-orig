package _00_Binary_Conversion;

/*
 * Goal: Learn how negative binary numbers are represented
 * 
 * In Java each primitive integer type (byte, short, int, long) is stored as
 * a specific number of binary digits, called bits:
 *      byte  = 8 bits
 *      short = 16 bits (2 bytes)
 *      int   = 32 bits (4 bytes)
 *      long  = 64 bits (8 bytes)
 * 
 * A byte has 8 bits so it can have 8 digits with any combination of 1 or 0.
 * For example,
 *      00000000    // 8 0s
 *      11111111    // 8 1s
 *      10101010    // mix of 0s and 1s
 * 
 * Because each digit can only be two possible values, a 1 or a 0, the total
 * number of different values a byte can represent is 2^8, or 256.
 * With 256 different values, half of those (128) are negative and the other
 * half are non-negative.
 *      -128 to -1  // negative byte values
 *         0 to 127 // non-negative byte values
 * 
 * To represent both groups of numbers the leftmost bit, bit 7, is used to
 * indicate if the number is negative or non-negative. For example,
 * bit 7            // If bit 7 is 1, the value is negative, otherwise it's not
 *      \
 *       01111111   //  127 decimal (largest non-negative value)
 *       00000000   //    0 decimal (smallest non-negative value)
 * 
 *       11111111   //   -1 decimal (largest negative value)
 *       10000000   // -128 decimal (smallest negative value)
 * 
 * Converting a number from non-negative to negative and negative to
 * non-negative is the same process.
 *      1. Invert all the bits
 *      2. Add 1
 * For example,
 *      00000111    // 7 decimal
 *      11111000    // invert bits
 *      11111001    // add +1, -7
 * This method is called two's complement:
 * https://en.wikipedia.org/wiki/Two%27s_complement
 * 
 * If you need to get the binary number of a negative value, find the positive
 * binary value, then invert the bits and add 1
 */
public class _04_NegativeBinaryNumbers {
    public static void main(String[] args) {
        /*
         * Negative number to positive number
         */
        byte b = (byte) 0b11111111;
        System.out.println(printBin(b));
        System.out.println("~11111111 + 1 = " + printBin((byte)(~b + 1)));
        
        /*
         * Positive number to negative number
         */
        b = (byte) 0b11000000;
        System.out.println();
        System.out.println(printBin(b));
        System.out.println("~11000000 + 1 = " + printBin((byte)(~b + 1)));
    }
    
    static String printBin(byte val) {
        String str = String.format("%32s", Integer.toBinaryString(val)).replace(' ',  '0').substring(32-8);
        return String.format("%8s", str) + " (" + val + ")";
    }
}
