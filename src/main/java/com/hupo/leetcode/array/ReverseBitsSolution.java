package com.hupo.leetcode.array;

public class ReverseBitsSolution {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i <= 31; i++) {
            result = result | (n >> 31 - i & 1) << i;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBitsSolution solution = new ReverseBitsSolution();
        System.out.println(solution.reverseBits(-3));
    }

    public String printBin(int n) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i <= 31; i++) {
            buffer.append(n >> 31 - i & 1);
        }
        return buffer.toString();
    }

}
