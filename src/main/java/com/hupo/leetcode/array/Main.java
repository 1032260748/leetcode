package com.hupo.leetcode.array;


import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line1 = scanner.nextLine();
            String line2 = scanner.nextLine();

        }
        scanner.close();
    }

    private int result(int m, int n) {
        return null;
    }

    public static boolean boolIsAllCharExist(String shortStr, String longStr) {

        Set<Character> shortSet = new HashSet<>();
        for (int i = 0; i < shortStr.length(); i++) {
            shortSet.add(shortStr.charAt(i));
        }

        Set<Character> longSet = new HashSet<>();
        for (int i = 0; i < longStr.length(); i++) {
            if (shortSet.contains(longStr.charAt(i))) {
                longSet.add(longStr.charAt(i));
            }
        }

        return longSet.size() == shortSet.size();

    }

    public static boolean exist(int[] array) {

        List<Integer> extra = new ArrayList<>();
        int extraSum = 0;
        int fiveSum = 0;
        int threeSum = 0;

        for (int i = 0; i < array.length; i++) {
            int currentNum = array[i];
            if (currentNum % 5 == 0) {
                fiveSum += currentNum;
            } else if (currentNum % 3 == 0) {
                threeSum += currentNum;
            } else {
                extraSum += currentNum;
                extra.add(currentNum);
            }
        }
        int ab = Math.abs(fiveSum - threeSum);
        if ((extraSum + ab) % 2 != 0) {
            return false;
        }
        return sum((extraSum + ab) / 2, extra, 0, 0);
    }

    public static boolean sum(int sum, List<Integer> list, int index, int count) {
        if (index == list.size() - 1) {
            if (sum == 0 && count > 0) {
                return true;
            }
            return sum == list.get(list.size() - 1);
        } else {
            return sum(sum, list, index + 1, count) || sum(sum - list.get(index), list, index + 1, count + 1);
        }
    }

    public static int fama(int n, int[] weight, int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        fama(weight, nums, 0, hashSet, 0);
        return hashSet.size();
    }

    public static void fama(int[] weight, int[] nums, int sum, Set<Integer> result, int index) {
        if (index >= weight.length) {
            if (!result.contains(sum)) {
                result.add(sum);
            }
            return;
        }
        for (int i = 0; i <= nums[index]; i++) {
            fama(weight, nums, sum + i * weight[index], result, index + 1);
        }
    }


}
