package com.hupo.leetcode.str;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class AddString {

    public static void main(String[] args) throws InterruptedException {
        String[] queries = new String[] { "IXfGawluvnCa", "IsXfGaxwulCa", "IXfGawlqtCva", "IXjfGawlmeCa",
                "IXfGnaynwlCa", "IXfGcamwelCa" };
        String pattern = "IXfGawlCa";
        List<Boolean> result = new AddString().camelMatch(
                queries, pattern);
        System.out.println(result);
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            result.add(match(queries[i], pattern));
        }
        return result;
    }

    public boolean match(String text, String pattern) {
        if (text == null || pattern == null) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < text.length() && j < pattern.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
                i++;
            } else {
                return false;
            }
        }
        if (i < text.length()) {
            while (i < text.length()) {
                if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
                    i++;
                } else {
                    return false;
                }
            }
            return true;
        } else {
            if (j >= pattern.length()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public int longestDecomposition(String text) {
        int[][] result = new int[text.length()][text.length()];
        for (int i = 0; i < text.length(); i++) {
            for (int j = i; j < text.length(); j++) {
                result[i][j] = 1;
            }
        }
        for (int j = 1; j < text.length(); j++) {
            for (int m = 1; m <= (j + 1) / 2; m++) {
                for (int i = 0; i < text.length(); i++) {
                    if (i + j < text.length()) {
                        if (headTailEquals(text, i, i + j, m)) {
                            result[i][i + j] = Math.max(result[i][i + j]
                                    , 2 + result[i + m][i + j - m]);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return result[0][text.length() - 1];
    }

    public boolean headTailEquals(String text, int start, int end, int length) {
        return start + length <= end - length + 1 && text.substring(start, start + length).equals(
                text.substring(end - length + 1, end + 1)
        );
    }

    public static class Foo {

        CountDownLatch second = new CountDownLatch(1);
        CountDownLatch third = new CountDownLatch(1);
        CountDownLatch all = new CountDownLatch(1);

        public Foo() {

        }

        public boolean allComplete() throws InterruptedException {
            all.await();
            System.out.println("all complete");
            return true;
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            second.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            second.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            third.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            third.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            all.countDown();
        }
    }

    public static class FooBar {
        private int n;

        private Lock lock = new ReentrantLock(true);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
            }
        }
    }

    public boolean wordPattern(String pattern, String s) {
        return true;
    }

    public int rangeBitwiseAnd(int left, int right) {
        return 0;
    }

    public int addDigits(int num) {
        int current = num;
        while (current >= 10) {
            int temp = current;
            int sum = 0;
            while (temp > 0) {
                sum = sum + temp % 10;
                temp = temp / 10;
            }
            current = sum;
        }
        return current;
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int newIndex = 0;
        int zeroCount = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                nums[newIndex] = nums[i];
                newIndex++;
            }
        }
        for (int i = nums.length - 1; i > nums.length - 1 - zeroCount; i--) {
            nums[i] = 0;
        }
    }

    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        StringBuilder buffer = new StringBuilder();
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int flag = 0;
        while (m >= 0 || n >= 0) {

            int number1 = 0;
            int number2 = 0;
            if (m >= 0) {
                number1 = num1.charAt(m) - '0';
            }
            if (n >= 0) {
                number2 = num2.charAt(n) - '0';
            }

            int current = (number1 + number2 + flag) % 10;
            buffer.insert(0, current);

            flag = (number1 + number2 + flag) / 10;

            m--;
            n--;
        }
        if (flag > 0) {
            buffer.insert(0, flag);
        }
        return buffer.toString();
    }

}
