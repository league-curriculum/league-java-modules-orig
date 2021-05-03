package _01_Encapsulate_the_Data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class EncapsulateTheDataTest {

    EncapsulateTheData testData = new EncapsulateTheData();

    @Test
    void itemsReceivedEncapsulated() {

        assertTrue(isEncapsulated("itemsReceived"));

    }

    @Test
    void itemsReceivedGetterSetter() {

        int randomPositiveNum = new Random().nextInt(100 + 1);

        testData.setItemsReceived(randomPositiveNum);

        assertEquals(randomPositiveNum, testData.getItemsReceived());

    }

    @Test
    void itemsReceivedNotNegative() {

        int randomNegativeNum = new Random().nextInt(100) - 100;

        testData.setItemsReceived(randomNegativeNum);

        assertEquals(0, testData.getItemsReceived());

    }

    @Test
    void degreesTurnedEncapsulated() {

        assertTrue(isEncapsulated("degreesTurned"));

    }

    @Test
    void degreesTurnedGetterSetter() {

        double randomPositiveNum = new Random().nextDouble() * 360;

        testData.setDegreesTurned(randomPositiveNum);

        assertEquals(randomPositiveNum, testData.getDegreesTurned());

    }

    @Test
    void degreesTurnedNotOutsideBounds() {

        double randomNumOutsideBounds = new Random().nextDouble() * 360;

        if (randomNumOutsideBounds >= 180) {
            randomNumOutsideBounds += 360;
        } else {
            randomNumOutsideBounds -= 360;
        }

        testData.setDegreesTurned(randomNumOutsideBounds);

        double boundedNum = testData.getDegreesTurned();

        assertTrue(boundedNum >= 0 && boundedNum <= 360);

    }

    @Test
    void nomenclatureEncapsulated() {

        assertTrue(isEncapsulated("nomenclature"));

    }

    @Test
    void nomenclatureGetterSetter() {

        String randomString = new Random().nextInt() + "";

        testData.setNomenclature(randomString);

        assertEquals(randomString, testData.getNomenclature());

    }

    @Test
    void nomenclatureNotBlank() {

        String blankString = "";

        testData.setNomenclature(blankString);

        assertEquals(" ", testData.getNomenclature());

    }

    @Test
    void memberObjEncapsulated() {

        assertTrue(isEncapsulated("memberObj"));

    }

    @Test
    void memberObjGetterSetter() {

        Object randomObject = new Object();

        testData.setMemberObj(randomObject);

        assertEquals(randomObject, testData.getMemberObj());

    }

    @Test
    void memberObjNotString() {

        String blankString = "";

        testData.setMemberObj(blankString);

        assertFalse(testData.getMemberObj() instanceof String);

    }

    private boolean isEncapsulated(String memberVariableName) {

        boolean encapsulated = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader(
                    "src/_01_Encapsulate_the_Data/EncapsulateTheData.java"));

            String line = br.readLine();

            while (line != null) {

                if (line.contains(memberVariableName) && !line.contains("*")) {
                    encapsulated = line.contains("private")
                            || line.contains("protected");
                    break;

                }

                line = br.readLine();
            }

            br.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {

            ex.printStackTrace();
        }

        return encapsulated;
    }

}

