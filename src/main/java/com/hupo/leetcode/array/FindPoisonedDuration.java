package com.hupo.leetcode.array;

public class FindPoisonedDuration {

    public int findPoisonedDuration(int[] timeSeries, int duration) {

        int result = 0;

        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }

        int end = 0;

        for (int i = 0; i <= timeSeries.length - 1; i++) {
            if (end <= timeSeries[i]) {
                result = result + duration;
            } else {
                result = result + duration - (end - timeSeries[i]);
            }
            end = timeSeries[i] + duration;
        }
        return result;
    }
}
