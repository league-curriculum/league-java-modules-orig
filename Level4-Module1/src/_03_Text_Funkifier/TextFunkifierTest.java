package _03_Text_Funkifier;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class TextFunkifierTest {

    /**
     * 1. In BackwardsString implement the funkifyText method inherited from
     * TextFunkifier so that it returns the unfunkifiedText String backwards.
     */

    @Test
    public void testBackwardsString() {
        BackwardsString bs = new BackwardsString("This is a test");
        assertEquals("tset a si sihT", bs.funkifyText());
    }

    /**
     * 2. Implement the the TextFunkifier interface in MixedCapsString. Then
     * implement the funkifyText method so it returns the unfunkifiedText String
     * with alternating cases starting with lower case.
     */

    @Test
    public void testMixedCapsString() {
        MixedCapsString mcs = new MixedCapsString("This is also a test");
        assertEquals("tHiS Is aLsO A TeSt", mcs.funkifyText());
    }

    /**
     * 3. Make your own class similar to the previous classes that implements
     * TextFunkifier and has a private String member variable called
     * unfunkifiedText.
     * 
     * 4. Implement funkifyText method so that it returns unfunkifiedText String
     * modified in a way of your choosing that is different from those in
     * previous steps.
     * 
     * 5. Create a matching JUnit test below to test for your custom String and
     * make it pass.
     */

    @Test
    public void testCustomString() {
        
        CustomString cs = new CustomString("This is a custom test");
        assertEquals("Test custom a is this", cs.funkifyText());

    }
}
