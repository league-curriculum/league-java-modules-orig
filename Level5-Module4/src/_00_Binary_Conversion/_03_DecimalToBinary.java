package _00_Binary_Conversion;

/*
 * Goal: Learn how to convert decimal to binary
 *
 * EXAMPLE: Convert 43 to binary
 * 
 * Step 1: Divide the number by 2.
 * Step 2: Write down the remainder from the division.
 *         For example, 5 / 2 => 2 remainder 1, so write a 1.
 * Step 3: Repeat steps 1 and 2 until the number is 0.
 *    Example, convert decimal 43 into binary:
 *    43
 *    43 / 2 = 21 remainder 1
 *    21 / 2 = 10 remainder 1
 *    10 / 2 = 5  remainder 0
 *    5  / 2 = 2  remainder 1
 *    2  / 2 = 1  remainder 0
 *    1  / 2 = 0  remainder 1
 *    0 reached, END
 * 
 *    Starting from the bottom, write the remainders from left to right.
 *    1 0 1 0 1 1 = 43!
 *
 * Why this method works:
 * ----------------------
 * The division by 2 and round down is the same as a binary right shift by 1.
 * For example, the number 7 in binary is 111b. If we shift all the bits once to the
 * right the number is 11b, which is 3 (remember, there are no fractions for integers
 * so it's not 11.1b. The rightmost binary 1 is discarded).
 *
 * Checking the remainder is the same as checking if the rightmost binary digit
 * was a 1 or a 0 after the right shift removed it from the binary number.
 *
 * As the decimal number is continually divided by 2 (binary right shifted), the
 * number keeps getting smaller until it reaches 0 and all the binary digits are
 * accounted for.
 * 
 *     decimal      binary
 *        43        101011
 *        21         10101 (notice the rightmost 1 is gone!)
 *        10          1010
 *         5           101
 *         2            10
 *         1             1
 *         0             0
 *
 * Challenge:
 * ----------
 * What about negative decimal numbers? Does the same method work? Below is a
 * method that converts a decimal integer to a String of binary digits. Enter
 * a negative number and check if it matches your calculations.
 *  *hint* https://en.wikipedia.org/wiki/Two%27s_complement
 */
public class _03_DecimalToBinary {
    public static void main(String[] args) {
        System.out.println(" 43 in binary: " + String.format("%32s", convertDecimalToBinary(43)).replace(' ', '0'));
        System.out.println("-43 in binary: " + convertDecimalToBinary(-43));
    }

    public static String convertDecimalToBinary(int decimalNum) {
        String binaryStr = "";

        do {
            // 1. Logical right shift by 1
            int quotient = decimalNum >>> 1;

            // 2. Check remainder and add '1' or '0'
            if( decimalNum % 2 != 0 ){
                binaryStr = '1' + binaryStr;
            } else {
                binaryStr = '0' + binaryStr;
            }

            decimalNum = quotient;

            // 3. Repeat until number is 0
        } while( decimalNum != 0 );

        return binaryStr;
    }
}
