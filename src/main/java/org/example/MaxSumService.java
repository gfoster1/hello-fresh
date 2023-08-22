package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxSumService {
    public MaxSumResult findMaxConsecutiveSum(Integer[] input) {
        if (input.length < 2) {
            throw new IllegalArgumentException("bad args");
        }

        List<MaxSumResult> currentValues = new ArrayList<>();
        for (int i = 1; i < input.length; i++) {
            // TODO add optimization to check if the added value is > current max
            final int value = input[i];
            int s = currentValues.size();
            for (int j = 0; j < s; j++) {
                var previousValue = currentValues.remove(0);
                var currentValue = new MaxSumResult(previousValue.getSum() + value, previousValue.start, i);
                currentValues.add(currentValue);
            }
            currentValues.add(new MaxSumResult(input[i] + input[i - 1], i - 1, i));
        }
        return currentValues.stream().max(Comparator.comparingInt(t -> t.sum)).get();
    }

    public static final class MaxSumResult {
        private final int sum;
        private final int start;
        private final int end;

        public MaxSumResult(int sum, int start, int end) {
            this.sum = sum;
            this.start = start;
            this.end = end;
        }

        public int getSum() {
            return sum;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}
