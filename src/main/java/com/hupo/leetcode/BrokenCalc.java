package com.hupo.leetcode;

public class BrokenCalc {


    public int brokenCalc(int X, int Y) {

        int result = 0;
        while (Y > X) {
            if (Y % 2 == 0) {
                Y = Y / 2;
                result++;
            } else {
                Y = Y + 1;
                result++;
            }
        }

        return result + (Y - X);

    }
}
