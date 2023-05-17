package com.hupo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NumberPair {

    public static void main(String[] args) {
        NumberPair numberPair = new NumberPair();
        List<List<Integer>> lists = numberPair.pairSums2(new int[] { -2, -1, 0, 3, 5, 6, 6, 6, 7, 9, 13, 14 }, 12);
        System.out.println(lists.size());
    }

    public List<List<Integer>> pairSums2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                result.add(Arrays.asList(nums[left], nums[right]));
                right--;
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> numberCount = new HashMap<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            int currentNumber = nums[i];
            if (numberCount.containsKey(nums[i])) {
                numberCount.put(currentNumber, numberCount.get(currentNumber) + 1);
            } else {
                numberCount.put(currentNumber, 1);
            }
        }
        for (int i = 0; i <= nums.length - 1; i++) {
            int currentNumber = nums[i];
            if (numberCount.containsKey(currentNumber)) {
                int count = numberCount.get(currentNumber);
                if (count <= 0) {
                    numberCount.remove(currentNumber);
                } else {
                    int otherNumber = target - currentNumber;
                    if (numberCount.containsKey(otherNumber)) {
                        if (otherNumber == currentNumber) {
                            if (count >= 2) {
                                result.add(Arrays.asList(currentNumber, otherNumber));
                                numberCount.put(currentNumber, count - 2);
                            }
                        } else {
                            int otherCount = numberCount.get(otherNumber);
                            if (otherCount <= 0) {
                                numberCount.remove(otherNumber);
                            } else {
                                if (currentNumber < otherNumber) {
                                    result.add(Arrays.asList(currentNumber, otherNumber));
                                } else {
                                    result.add(Arrays.asList(otherNumber, currentNumber));
                                }
                                numberCount.put(currentNumber, numberCount.get(currentNumber) - 1);
                                numberCount.put(otherNumber, numberCount.get(otherNumber) - 1);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
