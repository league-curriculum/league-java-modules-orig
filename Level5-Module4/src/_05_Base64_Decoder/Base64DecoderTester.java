package _05_Base64_Decoder;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class Base64DecoderTester {

    @Test
    public void testConvertBase64Char() {
        assertEquals(0, Base64Decoder.convertBase64Char('A'));
        assertEquals(1, Base64Decoder.convertBase64Char('B'));
        assertEquals(4, Base64Decoder.convertBase64Char('E'));
        assertEquals(63, Base64Decoder.convertBase64Char('/'));
        assertEquals(27, Base64Decoder.convertBase64Char('b'));
        assertEquals(45, Base64Decoder.convertBase64Char('t'));
    }

    @Test
    public void testBase64ToByteArray() {
        byte[] answer = { 0, 0, 0 };
        byte[] check = Base64Decoder.convert4CharsTo24Bits("AAAA");
        // 000.000 000.000 000.000 000.000
        // 0000.0000 0000.0000 0000.0000
        assertArrayEquals(answer, check);

        answer[0] = (byte) 255;
        answer[1] = (byte) 255;
        answer[2] = (byte) 255;
        check = Base64Decoder.convert4CharsTo24Bits("////");
        // 111.111 111.111 111.111 111.111
        // 1111.1111 1111.1111 1111.1111
        assertArrayEquals(answer, check);

        answer[0] = (byte) 7;
        answer[1] = (byte) 13;
        answer[2] = (byte) 126;
        check = Base64Decoder.convert4CharsTo24Bits("Bw1+");
        // 000.001 110.000 110.101 111.110
        // 0000.0111 0000.1101. 0111.1110
        assertArrayEquals(answer, check);
    }

    @Test
    public void testBase64StringToByteArray() {
        String file = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/_04_Base64_Decoder/base64_data.txt"));
            String line = br.readLine();
            while (line != null) {
                file += line;
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] bits = Base64Decoder.base64StringToByteArray(file);
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/_04_Base64_Decoder/decoded_string.txt"));
            String line = br.readLine();
            int ctr = 0;
            while (line != null) {
                assertEquals(bits[ctr++], Byte.parseByte(line));
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
