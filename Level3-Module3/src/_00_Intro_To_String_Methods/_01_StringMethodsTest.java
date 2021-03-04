package _00_Intro_To_String_Methods;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class _01_StringMethodsTest {

    @Test 
    void testLongerString() {
        assertEquals("A", _01_StringMethods.longerString("", "A"));
        assertEquals("A", _01_StringMethods.longerString("A", ""));
        assertEquals("equal", _01_StringMethods.longerString("equal", "equal"));
    }

    @Test
    void testFormatSpaces() {
        assertEquals("This String should not chage", _01_StringMethods.formatSpaces("This String should not chage"));
        assertEquals("This_String_should_have_its_spaces_filled_with_underscores", _01_StringMethods.formatSpaces("This String should have its spaces filled with underscores"));
        assertEquals("x_x_x_x_x_x_x_underscores_x_x_x_x_x_x", _01_StringMethods.formatSpaces("x x x x x x x underscores x x x x x x"));
    }

    @Test 
    void testLineLeader() {
        assertEquals("John A", _01_StringMethods.lineLeader("John C", "John B", "John A"));
        assertEquals("John A", _01_StringMethods.lineLeader("           John A  ", " John C   ", "     John B "));
        assertEquals("Charley F", _01_StringMethods.lineLeader("  Allison Z", " Charley F ", " Brad H "));
    }

    @Test
    void testNumeralSum() {
        assertEquals(0, _01_StringMethods.numeralSum(""));
        assertEquals(5, _01_StringMethods.numeralSum("11111"));
        assertEquals(3, _01_StringMethods.numeralSum("a1b2c"));
        assertEquals(45, _01_StringMethods.numeralSum("x1x2x3x4x5x6x7x8x9x"));
    }

    @Test
    void testSubstringCount() {
        assertEquals(3, _01_StringMethods.substringCount("subsubsub", "sub"));
        assertEquals(2, _01_StringMethods.substringCount("s ubsubsu bsubs ub", "sub"));
        assertEquals(3, _01_StringMethods.substringCount("Here I'm counting spaces"," "));
        assertEquals(0, _01_StringMethods.substringCount("There shoudn't be matches here", "tuna"));
    }

    @Test
    void testEncrypt() {
        assertEquals("KwYPDww=", _01_StringMethods.encrypt("Hello", 'c'));
        assertEquals("FCglYAwlISc1JWAvJmABLSE6KS4nYBAyLycyIS0tJTIz", _01_StringMethods.encrypt("The League of Amazing Programmers", '@'));
        assertEquals("JBkdFVAEH1AVEQRQAx8dFVAAAhUEChUcAw==", _01_StringMethods.encrypt("Time to eat some pretzels", 'p'));
    }

    @Test
    void testDecrypt() {
        assertEquals("Hello", _01_StringMethods.decrypt("KwYPDww=", 'c'));
        assertEquals("The League of Amazing Programmers", _01_StringMethods.decrypt("FCglYAwlISc1JWAvJmABLSE6KS4nYBAyLycyIS0tJTIz" , '@'));
        assertEquals("Time to eat some pretzels", _01_StringMethods.decrypt("JBkdFVAEH1AVEQRQAx8dFVAAAhUEChUcAw==", 'p'));
    }

    @Test
    void testWordsEndWithSubstring() {
        assertEquals(3, _01_StringMethods.wordsEndsWithSubstring("He quietly and slowly backed away from the bear that was hungrily looking at him", "ly"));
        assertEquals(2, _01_StringMethods.wordsEndsWithSubstring("He was visiting The League of Amazing Programmers.", "ing"));
        assertEquals(7, _01_StringMethods.wordsEndsWithSubstring("Here are multiple words that have the same letter at the end.", "e"));
        assertEquals(0, _01_StringMethods.wordsEndsWithSubstring("This should give us zero matches", "lemonade"));
    }

    @Test
    void testDistance() {
        assertEquals(6, _01_StringMethods.distance("subsubsubsub", "sub"));
        assertEquals(7, _01_StringMethods.distance("subsubsubsub", "ub"));
        assertEquals(28, _01_StringMethods.distance("The League The Le ague TheLeag ue The League", "League"));
        assertEquals(0, _01_StringMethods.distance("bb", "b"));
    }

    @Test
    void testPalindrome() {
        assertTrue(_01_StringMethods.palindrome("ABA"));
        assertTrue(_01_StringMethods.palindrome("ABBA"));
        assertTrue(_01_StringMethods.palindrome("racecar"));
        assertTrue(_01_StringMethods.palindrome("Was it a cat I saw?"));
        assertTrue(_01_StringMethods.palindrome("A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal - Panama"));
        assertTrue(_01_StringMethods.palindrome("Doc, Note: I Dissent. A Fast Never Prevents A Fatness. I Diet On Cod."));
        assertFalse(_01_StringMethods.palindrome("abcdefghijklmnopqrstuvwxyz"));
        assertFalse(_01_StringMethods.palindrome("This is not a palendrome"));
        assertFalse(_01_StringMethods.palindrome("This is close but not quite right etiuq ton tub esolc si sihT"));
    }
}
