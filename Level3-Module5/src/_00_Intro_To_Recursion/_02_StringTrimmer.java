package _00_Intro_To_Recursion;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class _02_StringTrimmer {

    static public String trimString(String str, int removesLeft) {
        // 1. If there are no removes left
        if(removesLeft == 0) {
            // 2. Return the string
            return str;
        } else {
            str = str.substring(0, str.length()-1);
            removesLeft--;
            return trimString(str, removesLeft);
        }

        // 3. Else you need to remove the last letter from the string,
        //    reduce removesLeft by 1, and then call trimString() 
    }

    @Test
    void TestStringTrim() {
        assertEquals("Hello W", trimString("Hello World!", 5));
        assertEquals("League", trimString("LeagueOfAmazing!", 10));
        assertEquals("James", trimString("JamesTheIntern", 9));
        assertEquals("", trimString("TheWholeWord", 12));
    }
}
