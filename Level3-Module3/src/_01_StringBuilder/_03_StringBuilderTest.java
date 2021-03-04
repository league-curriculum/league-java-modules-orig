package _01_StringBuilder;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class _03_StringBuilderTest {

    @Test
    void appendTest() {
        char[] chars = { 'a', 'p', 'p', 'l', 'e', 's' };
        assertEquals("I like apples", _03_StringBuilder.append("I like ", chars));
    }
    
    @Test
    void reverseTest() {
        assertEquals("gnirts desrever", _03_StringBuilder.reverse("reversed string"));
    }
    
    @Test
    void insertTest() {
        assertEquals("Insert here -->!<--", _03_StringBuilder.insert("Insert here --><--", 15, '!'));
    }

    @Test
    void removeTest() {
        assertEquals("Remove  word", _03_StringBuilder.delete("Remove *this* word", 7, 13));
    }
}
