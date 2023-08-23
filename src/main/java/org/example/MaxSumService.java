package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxSumService {
    public MaxSumResult findMaxConsecutiveSum(Integer[] input) {
        if (input.length < 2) {
            throw new IllegalArgumentException("bad args");
        }

        var maximumMaxSumResult = new MaxSumResult(Integer.MIN_VALUE, -1, -1);
        List<MaxSumResult> currentValues = new ArrayList<>(input.length);
        for (int i = 1; i < input.length; i++) {
            final int value = input[i];
            int s = currentValues.size();
            for (int j = 0; j < s; j++) {
                var previousValue = currentValues.remove(0);
                MaxSumResult currentValue = new MaxSumResult(previousValue.sum() + value, previousValue.start, i);
                if (currentValue.sum > maximumMaxSumResult.sum()) {
                    maximumMaxSumResult = currentValue;
                }
                currentValues.add(currentValue);
            }
            var nextMaxSumResult = new MaxSumResult(input[i] + input[i - 1], i - 1, i);
            if (nextMaxSumResult.sum > maximumMaxSumResult.sum()) {
                maximumMaxSumResult = nextMaxSumResult;
            }
            currentValues.add(new MaxSumResult(input[i] + input[i - 1], i - 1, i));
        }
        return maximumMaxSumResult;
    }

    public record MaxSumResult(int sum, int start, int end) {
    }
}
