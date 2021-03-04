/*
 * Copyright (c) 2020, adrian.eyre All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE. The views and conclusions contained in the
 * software and documentation are those of the authors and should not be
 * interpreted as representing official policies, either expressed or implied,
 * of the FreeBSD Project.
 */

package _01_The_Wave;

import static org.junit.Assert.assertArrayEquals;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Instructions are in the other file!
 */
class _01_TheWaveTest {
    ArrayList<String> result = new ArrayList<String>();
    
    @BeforeEach
    public void setup() {
        result.clear();
    }
    
    @Test
    public void Test1() {
        ArrayList<String> result = _01_TheWave.wave("hello");
        String[] actual =  result.toArray( new String[result.size()] );
        String[] expected = new String[] { "Hello", "hEllo", "heLlo", "helLo", "hellO" };
        
        assertArrayEquals("it should return '" + Arrays.toString(expected) + "'", expected, actual);
    }
    
   @Test
    public void Test2() {
       ArrayList<String> result = _01_TheWave.wave("theleague");
       String[] actual =  result.toArray( new String[result.size()] );
       String[] expected = new String[] { "Theleague", "tHeleague", "thEleague", "theLeague", "thelEague", "theleAgue", "theleaGue", "theleagUe", "theleaguE", };
       
       assertArrayEquals("it should return '" + Arrays.toString(expected) + "'", expected, actual);
    }
    
    @Test
    public void Test3() {
        ArrayList<String> result = _01_TheWave.wave("");
        String[] actual =  result.toArray( new String[result.size()] );
        String[] expected = new String[] { };
        
        assertArrayEquals("it should return '" + Arrays.toString(expected) + "'", expected, actual);
    }
    
    @Test
    public void Test4() {
        ArrayList<String> result = _01_TheWave.wave("two words");
        String[] actual =  result.toArray( new String[result.size()] );
        String[] expected = new String[] { "Two words", "tWo words", "twO words", "two Words", "two wOrds", "two woRds", "two worDs", "two wordS" };
        
        assertArrayEquals("it should return '" + Arrays.toString(expected) + "'", expected, actual);
    }
    
    @Test
    public void Test5() {
        ArrayList<String> result = _01_TheWave.wave(" gap ");
        String[] actual =  result.toArray( new String[result.size()] );
        String[] expected = new String[] { " Gap ", " gAp ", " gaP " };
        
        assertArrayEquals("it should return '" + Arrays.toString(expected) + "'", expected, actual);
    }
}
