package com.hupo.leetcode.number;

public class SmallestRepunitDivByK {

    public static void main(String[] args) {
        int count = smallestRepunitDivByK(7);
        System.out.println(count);
    }

    public static int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) {
            return -1;
        }
        int temp = 1;
        int len = 1;
        while (temp % K != 0) {
            temp = temp % K;
            temp = temp * 10 + 1;
            len += 1;
        }
        return len;
    }

}
