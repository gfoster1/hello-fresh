package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSumServiceTest {
    MaxSumService maxSumService = new MaxSumService();

    @Test
    public void simple1ItemHappyPath() {
        var input = new Integer[]{2};
        var expectedOutput = maxSumService.findMaxConsecutiveSum(input);
        assertEquals(expectedOutput.getSum(), Integer.MIN_VALUE);
    }

    @Test
    public void minValueCheck() {
        var input = new Integer[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        var expectedOutput = maxSumService.findMaxConsecutiveSum(input);
        assertEquals(expectedOutput.getSum(), 0);
    }

    @Test
    @DisplayName("")
    public void simpleArray_findConsectutiveSum_fullArraySum() {
        var input = new Integer[]{2, -4, 2};
        var expectedOutput = maxSumService.findMaxConsecutiveSum(input);
        assertEquals(expectedOutput.getSum(), 0);
    }

    @Test
    public void test1() {
        var input = new Integer[]{2, -4, 2, -1, 3, -3, 10, -1, -11, -100, 8, -1};
        var expectedOutput = maxSumService.findMaxConsecutiveSum(input);
        assertEquals(expectedOutput.getSum(), 11);
    }

    @Test
    public void getsPositions() {
        var input = new Integer[]{2, -4, 2, -1, 3, -3, 10, -1, -11, -100, 8, -1};
        var expectedOutput = maxSumService.findMaxConsecutiveSum(input);
        assertEquals(expectedOutput.getStart(), 2);
        assertEquals(expectedOutput.getEnd(), 6);
    }
}