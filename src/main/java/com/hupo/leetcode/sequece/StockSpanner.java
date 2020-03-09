package com.hupo.leetcode.sequece;


import java.util.Stack;
import java.util.jar.JarEntry;

public class StockSpanner {

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
//        stockSpanner.next(100);
//        stockSpanner.next(80);
//        stockSpanner.next(60);
//        stockSpanner.next(70);
//        stockSpanner.next(60);
//        stockSpanner.next(75);
//        stockSpanner.next(85);

        char[] chars = "432121".toCharArray();
        stockSpanner.sortChars(chars, 0, chars.length - 1);
        System.out.println(new String(chars));

        System.out.println(stockSpanner.nextGreaterElement(12443322));
    }

    private Stack<Integer> stack = new Stack<>();

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {

        if (stack.isEmpty()) {
            stack.push(price);
            return 1;
        } else {
            Stack<Integer> temp = new Stack<>();
            while (!stack.isEmpty()) {
                int top = stack.peek();
                if (top < price) {
                    break;
                } else {
                    temp.push(stack.pop());
                }
            }

            int result = stack.size() + 1;
            stack.push(price);
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
            return result;
        }

    }


    public int nextGreaterElement(int n) {
        StringBuilder builder = new StringBuilder();
        int current = n;
        while (current > 0) {
            int temp = current % 10;
            builder.insert(0, temp);
            current = current / 10;
        }

        char[] chars = builder.toString().toCharArray();

        boolean find = false;

        int after = -1;
        int before = -1;

        for (int i = chars.length - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (chars[j] < chars[i]) {
                    find = true;
                    if (after < 0) {
                        after = i;
                        before = j;
                        continue;
                    }
                    if (j > before) {
                        before = j;
                        after = i;
                    } else if (j == before && chars[i] < chars[after]) {
                        after = i;
                    }
                }
            }
        }

        if (find == false) {
            return -1;
        } else {
            swap(chars, before, after);
            sortChars(chars, before + 1, chars.length - 1);
        }

        Long longValue = new Long(new String(chars));
        if (longValue > n && longValue <= Integer.MAX_VALUE) {
            return longValue.intValue();
        }
        return -1;

    }

    public void sortChars(char[] chars, int start, int end) {
        for (int i = start; i <= end; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= end; j++) {
                if (chars[j] < chars[minIndex]) {
                    minIndex = j;
                }
            }
            swap(chars, i, minIndex);
        }
    }

    public void swap(char[] chars, int m, int n) {
        char temp = chars[m];
        chars[m] = chars[n];
        chars[n] = temp;
    }
}
