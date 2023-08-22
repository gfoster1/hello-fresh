package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSumServiceTest {
    MaxSumService maxSumService = new MaxSumService();

    @Test
    public void simple1ItemHappyPath() {
        var input = new Integer[]{2};
        var actualOutput = maxSumService.findMaxConsecutiveSum(input);
        assertEquals(actualOutput.getSum(), Integer.MIN_VALUE);
    }

    @Test
    public void minValueCheck() {
        var input = new Integer[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        var actualOutput = maxSumService.findMaxConsecutiveSum(input);
        assertEquals(actualOutput.getSum(), 0);
    }

    @Test
    public void simpleArray_findConsecutiveSum_fullArraySum() {
        var input = new Integer[]{2, -4, 2, -1};
        var actualOutput = maxSumService.findMaxConsecutiveSum(input);
        assertEquals(actualOutput.getSum(), 1);
    }

    @Test
    public void simpleArray_findConsecutiveSum_correctPositions() {
        var input = new Integer[]{2, -4, 2, -1};
        var actualOutput = maxSumService.findMaxConsecutiveSum(input);
        assertEquals(actualOutput.getStart(), 2);
        assertEquals(actualOutput.getEnd(), 3);
    }

    @Test
    public void test1() {
        var input = new Integer[]{2, -4, 2, -1, 3, -3, 10, -1, -11, -100, 8, -1};
        var actualOutput = maxSumService.findMaxConsecutiveSum(input);
        assertEquals(actualOutput.getSum(), 7);
    }
}