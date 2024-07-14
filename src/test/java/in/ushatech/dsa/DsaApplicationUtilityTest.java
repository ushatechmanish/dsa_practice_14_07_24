package in.ushatech.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class DsaApplicationUtilityTest {

    @org.junit.jupiter.api.Test
    public void testMiddle() {
        assertArrayEquals(new int[] {}, DsaApplication.middle(null));
        assertArrayEquals(new int[] {}, DsaApplication.middle(new int[] {1}));
        assertArrayEquals(new int[] {}, DsaApplication.middle(new int[] {1, 2}));
        assertArrayEquals(new int[] {2}, DsaApplication.middle(new int[] {1, 2, 3}));
        assertArrayEquals(new int[] {2, 3, 4}, DsaApplication.middle(new int[] {1, 2, 3, 4, 5}));
    }

    @Test
    public void testSumDiagonalElements() {
        assertEquals(Integer.MIN_VALUE, DsaApplication.sumDiagonalElements(null));
        assertEquals(Integer.MIN_VALUE, DsaApplication.sumDiagonalElements(new int[][] {}));
        assertEquals(25, DsaApplication.sumDiagonalElements(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        assertEquals(10, DsaApplication.sumDiagonalElements(new int[][] {{1, 2}, {3, 4}}));
    }

    @Test
    public void testFindTopTwoScores() {
        assertArrayEquals(new int[] {}, DsaApplication.findTopTwoScores(null));
        assertArrayEquals(new int[] {}, DsaApplication.findTopTwoScores(new int[] {1}));
        assertArrayEquals(new int[] {2, 1}, DsaApplication.findTopTwoScores(new int[] {1, 2}));
        assertArrayEquals(new int[] {10, 5}, DsaApplication.findTopTwoScores(new int[] {1, 5, 3, 10, 4}));
    }

    @Test
    public void testFindMissingNumberInArray() {
        assertEquals(Integer.MIN_VALUE, DsaApplication.findMissingNumberInArray(null));
        assertEquals(Integer.MIN_VALUE, DsaApplication.findMissingNumberInArray(new int[] {}));
        assertEquals(4, DsaApplication.findMissingNumberInArray(new int[] {1, 2, 3, 5}));
        assertEquals(1, DsaApplication.findMissingNumberInArray(new int[] {2, 3, 4, 5}));
    }

    @Test
    public void testRemoveDuplicates() {
        assertEquals(0, DsaApplication.removeDuplicates(null));
        assertEquals(0, DsaApplication.removeDuplicates(new int[] {}));
        assertEquals(1, DsaApplication.removeDuplicates(new int[] {1}));
        assertEquals(2, DsaApplication.removeDuplicates(new int[] {1, 1, 2}));
        assertEquals(5, DsaApplication.removeDuplicates(new int[] {1, 1, 2, 3, 3, 4, 5}));
    }

    @Test
    public void testMaxProfit() {
        assertEquals(0, DsaApplication.maxProfit(new int[] {7, 6, 4, 3, 1}));
        assertEquals(5, DsaApplication.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    }

    @Test
    public void testTwoSum() {
        assertArrayEquals(new int[] {-1, -1}, DsaApplication.twoSum(null, 5));
        assertArrayEquals(new int[] {-1, -1}, DsaApplication.twoSum(new int[] {1}, 5));
        assertArrayEquals(new int[] {0, 1}, DsaApplication.twoSum(new int[] {2, 7, 11, 15}, 9));
        assertArrayEquals(new int[] {1, 2}, DsaApplication.twoSum(new int[] {3, 2, 4}, 6));
    }

    @Test
    public void testSearchInArray() {
        assertEquals(-1, DsaApplication.searchInArray(new int[] {}, 5));
        assertEquals(2, DsaApplication.searchInArray(new int[] {1, 2, 5, 3}, 5));
        assertEquals(-1, DsaApplication.searchInArray(new int[] {1, 2, 3}, 4));
    }

    @Test
    public void testMaxProduct() {
        assertEquals("60,50", DsaApplication.maxProduct(new int[] {10, 20, 30, 40, 50, 60}));
        assertEquals("6,5", DsaApplication.maxProduct(new int[] {1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void testIsUnique() {
        assertTrue(DsaApplication.isUnique(new int[] {1, 2, 3}));
        assertFalse(DsaApplication.isUnique(new int[] {1, 2, 2}));
    }

    @Test
    public void testPermutation() {
        assertTrue(DsaApplication.permutation(new int[] {1, 2, 3}, new int[] {3, 2, 1}));
        assertFalse(DsaApplication.permutation(new int[] {1, 2, 3}, new int[] {4, 5, 6}));
    }

    @Test
    public void testRotateMatrix() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        DsaApplication.rotateMatrix(matrix);
        assertEquals(Arrays.toString(new int[] {7, 4, 1}), Arrays.toString(matrix[0]));
        assertEquals(Arrays.toString(new int[] {8, 5, 2}), Arrays.toString(matrix[1]));
        assertEquals(Arrays.toString(new int[] {9, 6, 3}), Arrays.toString(matrix[2]));
    }
}
