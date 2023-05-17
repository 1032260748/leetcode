package com.hupo.leetcode.array;

public class ComputeAreaSolution {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        //(ay1 ,ay2)   (by1,by2)
        int y = length(ay1, ay2, by1, by2);
        int x = length(ax1, ax2, bx1, bx2);

        int all = (ay2 - ay1) * (ax2 - ax1) + (by2 - by1) * (bx2 - bx1);

        return all - x * y;
    }

    public int length(int ay1, int ay2, int by1, int by2) {
        int yLength = 0;
        if (by1 <= ay1) {
            if (by2 <= ay1) {
                return 0;
            }
            if (by2 > ay1) {
                if (by2 <= ay2) {
                    yLength = by2 - ay1;
                } else {
                    yLength = ay2 - ay1;
                }
            }
        } else {
            //by1>ay1;
            if (by1 >= ay2) {
                return 0;
            }
            if (by1 < ay2) {
                if (by2 <= ay2) {
                    yLength = by2 - by1;
                } else {
                    yLength = ay2 - by1;
                }
            }
        }
        return yLength;
    }
}
