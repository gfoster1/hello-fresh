package org.example;

public class MaxSumService {
    public MaxSumResult findMaxConsecutiveSum(Integer[] input) {
        int maxSum = Integer.MIN_VALUE;
        int start = -1;
        int end = -1;
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum = input[i];
            for (int j = i + 1; j < input.length; j++) {
                // check if sum is withbounds
                if (withinBounds(sum, input[j])) {
                    sum += input[j];
                    if (sum > maxSum) {
                        System.out.println("sum = " + sum);
                        maxSum = sum;
                        start = i;
                        end = j;
                    } else {
                        break;
                    }

                }
            }
        }
        return new MaxSumResult(maxSum, start, end);
    }

    private boolean withinBounds(int sum, int integer) {
        // test if negative
        if (sum < 0) {
            int i = sum + Integer.MAX_VALUE;
        } else if (sum > 0) {

        }
        return true;
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
