package com.hupo.leetcode;


import java.util.Arrays;

public class RescueBoats {

    public int numRescueBoats(int[] people, int limit) {

        if (people == null || people.length == 0) {
            return 0;
        }

        Arrays.sort(people);

        int low = 0;
        int high = people.length - 1;
        int result = 0;

        while (low <= high) {
            if (people[low] + people[high] <= limit) {
                low++;
                high--;
            } else {
                high--;
            }
            result++;
        }

        return result;
    }
}
