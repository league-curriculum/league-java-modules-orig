package _01_Bit_Shifting;

/*
 * Goal: Learn about bit shifting
 * 
 * Bit shifting is when all the digits of a binary number moved left or right.
 * For example,
 *      00010011            // original value
 *      00100110            // left shift by 1
 * 
 * All the bits move one place to the left, a 0 is added to the right, and the
 * leftmost bit is removed.
 * The code to do this uses '<<',
 *      byte b = 0b00010011;
 *      b = b << 2;     // shift 2 to the left 01001100
 * 
 * An example of a right shift,
 *      00010011            // original value
 *      00001001            // right shift by 1
 * 
 * All the bits move one place to the right, a 0 is added to the left, and the
 * rightmost bit is removed.
 * The code to right shift uses '>>' or '>>>'.
 *      byte b = 0b00010011;
 *      b = b >> 2;         // shift 2 to the right 00000100
 * 
 * The difference between >> and >>> is when there are negative int or long
 * integers and the leftmost bit (sign bit) is a 1. For example,
 *      int b = 0b10000000000000000000000000000000; // -2147483648 decimal
 *      b = b >> 1;         // b is 0b11000000000000000000000000000000
 *                          //      fill leftmost bit with 1
 *      b = b >>> 1;        // b is 0b01100000000000000000000000000000
 *                          //      fill leftmost bit with 0
 * 
 * >> and >>> are the same for positive numbers.
 */
public class _01_IntroToBitShifting {
    public static void main(String[] args) {
        int i = 0b00010011;
        System.out.println("i is ........: " + printBin(i));
        
        i = i << 2;
        System.out.println("i << 2 is ...: " + printBin(i));
        
        i = 0b10000000000000000000000000000000;
        System.out.println();
        System.out.println("i is ........: " + printBin(i));
        
        i = i >> 1;
        System.out.println("i >> 1 is ...: " + printBin(i));
        
        i = i >>> 1;
        System.out.println("i >>> 1 is ..: " + printBin(i));
    }
    
    static String printBin(int val) {
        return String.format("%32s", Integer.toBinaryString(val)).replace(' ', '0') + " (" + val + ")";
    }
}
