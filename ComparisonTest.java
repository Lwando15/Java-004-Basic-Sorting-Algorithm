import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ComparisonTest {

    @Test
    public void testBubbleSort() {
        int[] array = { 5, 2, 9, 1, 5, 6 };
        int[] expected = { 1, 2, 5, 5, 6, 9 };
        SortingComparison.bubbleSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSelectionSort() {
        int[] array = { 5, 2, 9, 1, 5, 6 };
        int[] expected = { 1, 2, 5, 5, 6, 9 };
        SortingComparison.selectionSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testInsertionSort() {
        int[] array = { 5, 2, 9, 1, 5, 6 };
        int[] expected = { 1, 2, 5, 5, 6, 9 };
        SortingComparison.insertionSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testIsSortedTrue() {
        int[] sortedArray = { 1, 2, 3, 4, 5 };
        assertTrue(SortingComparison.isSorted(sortedArray));
    }

    @Test
    public void testIsSortedFalse() {
        int[] unsortedArray = { 1, 3, 2, 5, 4 };
        assertFalse(SortingComparison.isSorted(unsortedArray));
    }

    @Test
    public void testGenerateRandomArray() {
        int size = 10;
        int[] array = SortingComparison.generateRandomArray(size);
        assertEquals(size, array.length);
    }
}
