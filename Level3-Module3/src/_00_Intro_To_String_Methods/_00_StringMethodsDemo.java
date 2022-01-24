package _00_Intro_To_String_Methods;

import java.util.Arrays;

public class _00_StringMethodsDemo {
    /*
     * In Java Strings are objects that are immutable, meaning you can't
     * directly modify or change them. Java provides methods that indirectly
     * modify a String by returning a new String object with the modifications.
     * 
     * Below are some common modifications to Strings
     */
    public static void main(String[] args) {
        String str = "Welcome to Java";
        
        // Getting a character from a string by index
        char character = str.charAt(2);  // 'l'
        System.out.println("Character at index 2: " + character);

        // Check if a character is a letter or a number
        System.out.println("Is " + str.charAt(2) + " a letter: " + Character.isAlphabetic(str.charAt(2)));
        System.out.println("Is " + str.charAt(2) + " a digit: " + Character.isDigit(str.charAt(2)));
        
        // Converting a String to a number
        // Do you remember Integer.parseInt()? or Double.parseDouble()?
        
        // Converting a number to a String
        // Do you remember how to combine Strings using +?
        
        // Convert string letters to all upper case or lower case
        System.out.println("All upper case: " + str.toUpperCase());
        System.out.println("All lower case: " + str.toLowerCase());

        // Getting a substring (sequence of characters) from a string
        String substring1 = str.substring(0, 7);    // "Welcome"
        String substring2 = str.substring(8, 10);   // "to"
        String substring3 = str.substring(11);      // "Java"
        System.out.println("substring1: " + substring1);
        System.out.println("substring2: " + substring2);
        System.out.println("substring3: " + substring3);
        
        // Removing whitespace from the beginning and end of a String
        String paddedStr = "    Welcome to Java     ";
        System.out.println("String with whitespace ..:" + paddedStr);
        System.out.println("String without whitespace:" + paddedStr.trim());
        
        // Finding the index of the first matching character
        int index = str.indexOf('o');
        System.out.println("\'o\' 1st appearance at index: " + index + " in '" + str + "'");
        index = str.indexOf('o', index+1);
        System.out.println("\'o\' 2nd appearance at index: " + index + " in '" + str + "'");
        
        // Replacing ALL characters from a string
        String replacedStr = str.replace(' ', '_');
        System.out.println("Replaced ' ' with '_': " + replacedStr);
        
        // Splitting a String into individual words
        String[] words = str.split(" "); // split on space character
        for( int i = 0; i < words.length; i++ ) {
            System.out.println("word " + i + ": " + words[i]);
        }
        
        // Converting a String to an array
        char[] strChars = str.toCharArray();
        System.out.println("String to char[]: " + Arrays.toString(strChars));
        
        // Converting a char array to a String
        String convertedStr = new String(strChars);
        System.out.println("char[] to string: " + convertedStr);
        
        // Find the number of times a substring (or character) appears in a string
        // Method #1: starting from the first character on the left, keep
        //            searching for the character until the end of the string
        String substring = "to";
        int numOccurances = 0;
        index = str.indexOf("to");
        while( index != -1 ) {
            numOccurances++;
            index = str.indexOf(substring, index + substring.length());
        }
        
        System.out.println("1. The substring '" + substring + "' appeared: " + numOccurances +
                           " times in the string '" + str + "'");
        
        // Find the number of times a substring (or character) appears in a string
        // Method #2: remove the substring, get the number of characters,
        //            removed, then divide by the number of characters in the
        //            substring
        substring = "to";
        String removedSubstring = str.replace(substring, "");
        numOccurances = (str.length() - removedSubstring.length()) / substring.length();
        
        System.out.println("2. The substring '" + substring + "' appeared: " + numOccurances +
                           " times in the string '" + str + "'");
    }
}
