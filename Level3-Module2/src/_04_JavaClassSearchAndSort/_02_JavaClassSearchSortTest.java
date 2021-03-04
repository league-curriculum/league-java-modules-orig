package _04_JavaClassSearchAndSort;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class _02_JavaClassSearchSortTest {
    
    @Test
    void testArraySort() {
        int[] unsorted = { 4, 3, 5, 0, 1, 2 };
        int[] sorted = { 0, 1, 2, 3, 4, 5 };
        
        assertTrue(Arrays.equals(sorted, _02_JavaClassSearchSort.arraySort(unsorted)));
    }

    @Test
    void testListSort() {
        Double[] unsorted = { 4.0, 3.0, 5.0, 0.0, 1.0, 2.0 };
        Double[] sorted = { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 };
        
        List<Double> unsortedList = new ArrayList<>(Arrays.asList(unsorted));
        List<Double> sortedList = new ArrayList<>(Arrays.asList(sorted));
        
        assertEquals(sortedList, _02_JavaClassSearchSort.listSort(unsortedList));
    }

    @Test
    void testArraySearch() {
        char[] unsorted = { 'r', 'a', 'q', 'p', 'g', 'z' };

        assertTrue(_02_JavaClassSearchSort.arraySearch(unsorted, 'p'));
        assertFalse(_02_JavaClassSearchSort.arraySearch(unsorted, 'm'));
    }

    @Test
    void testListSearch() {
        Character[] unsorted = { 'r', 'a', 'q', 'p', 'g', 'z' };
        List<Character> unsortedList = new ArrayList<>(Arrays.asList(unsorted));
        
        assertTrue(_02_JavaClassSearchSort.listSearch(unsortedList, 'p'));
        assertFalse(_02_JavaClassSearchSort.listSearch(unsortedList, 'm'));
    }
}
