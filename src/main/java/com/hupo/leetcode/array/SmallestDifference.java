package com.hupo.leetcode.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;


public class SmallestDifference {

    public static class NestedInteger {

        private Integer value;

        private List<NestedInteger> nestedIntegers;

        // Constructor initializes an empty nested list.
        public NestedInteger() {
            this.nestedIntegers = new ArrayList<>();
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            this.nestedIntegers = new ArrayList<>();
            this.value = value;
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return this.value != null && (this.nestedIntegers == null || this.nestedIntegers.size() == 0);
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return this.value;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            this.value = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            this.nestedIntegers.add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return this.nestedIntegers;
        }
    }

    public static void main(String[] args) {

        SmallestDifference difference = new SmallestDifference();
        difference.deserialize("");

    }

    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        Deque<NestedInteger> stack = new ArrayDeque<NestedInteger>();
        int num = 0;
        boolean negative = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-') {
                negative = true;
            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                stack.push(new NestedInteger());
            } else if (c == ',' || c == ']') {
                if (Character.isDigit(s.charAt(i - 1))) {
                    if (negative) {
                        num *= -1;
                    }
                    stack.peek().add(new NestedInteger(num));
                }
                num = 0;
                negative = false;
                if (c == ']' && stack.size() > 1) {
                    NestedInteger ni = stack.pop();
                    stack.peek().add(ni);
                }
            }
        }
        return stack.pop();
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            ret.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return ret;
    }

    private Integer next(Integer i, int target) {
        if (i * 10 < target) {
            return i * 10;
        } else if (i + 1 < target) {
            return i + 1;
        } else {
            return null;
        }
    }

    public List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }

    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int min = Integer.MAX_VALUE;

        return min;
    }

    /**
     * 定义dp数组，dp[i]表示第i个丑数，因此dp[1]=1，最终答案为dp[n]。
     * 定义三个指针p2、p3、p5，分别表示下一个丑数是当前指针指向的丑数乘以对应的质因数，初始时，三个指针的值都是1。
     * 当i>=2时，状态转移方程为d p [ i ] = m i n ( d p [ p 2 ] ∗ 2 , d p [ p 3 ] ∗ 3 , d p [ p 5 ] ∗ 5 ) dp[i]=min(dp[p2]*2,
     * dp[p3]*3,dp[p5]*5)dp[i]=min(dp[p2]∗2,dp[p3]∗3,dp[p5]∗5)
     * 同时需要比较dp[i]和dp[p2]*2、dp[p3]*3、dp[p5]*5的值是否相等，如果相等对应的指针加一
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1; //定义三个指针
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            //必须是三个if，因为有可能一个值和多个值相等，指针都需要增加
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n]; //返回第n个丑数
    }
}
