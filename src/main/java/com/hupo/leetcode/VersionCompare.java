package com.hupo.leetcode;

public class VersionCompare {
    public int singleNumber(int[] nums) {

        int result = nums[0];

        for (int i = 1; i <= nums.length - 1; i++) {
            result = result ^ nums[i];
        }

        return result;

    }


    public int compareVersion(String version1, String version2) {


        String[] list1 = new String[]{"0"};
        String[] list2 = new String[]{"0"};

        if (version1 != null && version1.length() > 0) {
            list1 = version1.split("\\.");
        }

        if (version2 != null && version2.length() > 0) {
            list2 = version2.split("\\.");
        }

        int min = Math.min(list1.length, list2.length);

        for (int i = 0; i <= min - 1; i++) {
            int num1 = Integer.parseInt(list1[i]);
            int num2 = Integer.parseInt(list2[i]);

            if (num1 == num2) {
                continue;
            }
            if (num1 < num2) {
                return -1;
            } else {
                return 1;
            }
        }

        if (list1.length > min) {
            for (int i = min; i < list1.length; i++) {
                if (Integer.parseInt(list1[i]) > 0) {
                    return 1;
                }
            }
        }

        if (list2.length > min) {
            for (int i = min; i < list2.length; i++) {
                if (Integer.parseInt(list2[i]) > 0) {
                    return 1;
                }
            }
        }

        return 0;

    }
}
