package com.hupo.leetcode;


import java.util.*;

public class FindPath {
    public int findPaths(int m, int n, int N, int i, int j) {
        return 0;
    }

    public List<Point> getSurround(Point point, int m, int n) {
        List<Point> list = new ArrayList<>();
        if (point.x > 0) {
            list.add(new Point(point.x - 1, point.y));
        }
        if (point.x < m) {
            list.add(new Point(point.x + 1, point.y));
        }

        if (point.y > 0) {
            list.add(new Point(point.x, point.y - 1));
        }
        if (point.y < n) {
            list.add(new Point(point.x, point.y + 1));
        }
        return list;
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

        @Override
        public boolean equals(Object object) {
            if (object == null) {
                return false;
            }
            if (!(object instanceof Point)) {
                return false;
            }

            Point other = (Point) object;

            return this.x == other.x && this.y == other.y;
        }

        @Override
        public int hashCode() {
            return ((this.x) + "," + (this.y)).hashCode();
        }


    }
}
