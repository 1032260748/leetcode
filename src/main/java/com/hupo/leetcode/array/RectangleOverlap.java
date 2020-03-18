package com.hupo.leetcode.array;

public class RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        Point leftDown1 = new Point(rec1[0], rec1[1]);
        Point rightUp1 = new Point(rec1[2], rec1[3]);

        Point leftDown2 = new Point(rec2[0], rec2[1]);
        Point rightUp2 = new Point(rec2[2], rec2[3]);

        boolean result = leftDown2.y < rightUp1.y && rightUp2.y > leftDown1.y;
        result = result && (leftDown2.x < rightUp1.x && rightUp2.x > leftDown1.x);
        return result;
    }

    public static class Point {
        public int x;
        public int y;

        public Point() {

        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
