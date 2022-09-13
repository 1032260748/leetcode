package com.hupo.leetcode.array;

import java.util.*;


public class CuttingRope {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String shortStr = sc.nextLine();
        String longStr = sc.nextLine();
        System.out.println(longStr.contains(shortStr));
    }

    public int longestValidParentheses(String s) {

        int left = 0;
        int right = 0;
        int index = 0;

        int result = 0;
        while (index <= s.length() - 1) {

            if (s.charAt(index) == '(') {
                left++;
            } else if (s.charAt(index) == ')') {
                if (right < left) {
                    right++;
                } else if (right == left) {
                    result = Math.max(left * 2, result);
                    left = 0;
                    right = 0;
                }
            }
            index++;
        }

        result = Math.max(result, Math.min(left, right) * 2);
        return result;

    }

    public static String convertDouble(double num) {
        long fdk = new Double(num).longValue();

        long yi = fdk / new Double(Math.pow(10, 8)).longValue();
        return null;
    }

    private static String convert(long w) {

        String result = "";

        if (w > 1000) {
            long qian = w / 1000;
            result = result + qian + "千";
            w = w % 1000;
        }

        if (w > 100) {
            long bai = w / 100;
            result = result + bai + "百";
            w = w % 100;
        } else {
            if (result.endsWith("千")) {
                result = result + "零";
            }
        }

        return null;

    }

    public static String converse(String str) {
        String[] tempList = str.split(" ");
        List<String> array = Arrays.asList(tempList);
        Collections.reverse(array);
        return String.join(" ", array);
    }

    public static String convert(int num) {
        StringBuilder builder = new StringBuilder();
        int temp = num;
        while (temp > 0) {
            builder.append(temp % 10);
            temp = temp / 10;
        }
        return builder.toString();
    }

    public static int count(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (0 <= str.charAt(i) && str.charAt(i) <= 128) {
                if (!set.contains(str.charAt(i))) {
                    set.add(str.charAt(i));
                }
            }
        }
        return set.size();
    }

}
