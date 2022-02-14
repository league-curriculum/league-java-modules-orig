package _00_Binary_Conversion;

/*
 * Goal: Understand binary numbers
 * 
 * A decimal number is a number whose digits are a number from 0-9
 * A binary number is a number whose digits are either 1 or 0.
 * For example,
 *      1906    // 4-digit decimal number
 *      1010    // 4-digit binary number
 * 
 * Each digit in a decimal number represents a power of 10, meaning
 * the decimal number 1906 can be re-written as:
 *      1906 = (1 * 10^3) + (9 * 10^2) + (0 * 10^1) + (6 * 10^0)
 *           =    1000    +    900     +     0      +  6   (FYI 10^0 = 1)
 * 
 *      for each quantity in parenthesis,
 *             (1 * 10^3)   // 1 is the value at the digit
 *                          // 10 is the number of possible characters for each digit
 *                          // 3 is the number of digits from the right (the thousandth place)
 * 
 * The same rules apply for binary. The only difference is the number of
 * possible characters for each digit. For decimal it's 10, for binary it's 2.
 *      1010 = (1 * 2^3) + (0 * 2^2) + (1 * 2^1) + (0 * 2^0)
 *           =     8     +     0     +     2     +    0
 *           = 10 decimal
 * 
 * Any integer you can represent in decimal can be represented in binary, you
 * just need more digits.
 * 
 * Binary is important for computers because all integers stored on the
 * computer are in binary, not decimal. When a number is printed it's
 * automatically converted to decimal because it's the standard convention.
 * 
 * Below are examples of how to use binary numbers.
 */
public class _01_IntroToBinary {
    public static void main(String[] args) {
        /*
         * The '0b' prefix before a binary number tells Java the following
         * digits are in binary. By default the digits are decimal.
         */
        int binaryNum = 0b1001;
        int decimalNum = 1001;
        System.out.println("Binary num ....: " + binaryNum);
        System.out.println("Decimal num ...: " + decimalNum);
    }
}
