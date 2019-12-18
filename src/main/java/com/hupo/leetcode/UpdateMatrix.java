package com.hupo.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class UpdateMatrix {

    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }

        int[][] result = new int[matrix.length][matrix[0].length];

        Queue<Point> queue = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = Integer.MAX_VALUE;

                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                    queue.add(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point head = queue.remove();

            List<Point> surround = getPointSurround(head, matrix);

            if (surround != null && surround.size() > 0) {
                for (Point point : surround) {
                    if (result[point.x][point.y] > result[head.x][head.y] + 1) {
                        result[point.x][point.y] = result[head.x][head.y] + 1;
                        queue.add(point);
                    }
                }
            }
        }

        return result;
    }

    private List<Point> getPointSurround(Point point, int[][] matrix) {
        List<Point> points = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        if (point.x - 1 >= 0 && matrix[point.x - 1][point.y] == 1) {
            points.add(new Point(point.x - 1, point.y));
        }

        if (point.x + 1 < m && matrix[point.x + 1][point.y] == 1) {
            points.add(new Point(point.x + 1, point.y));
        }

        if (point.y - 1 >= 0 && matrix[point.x][point.y - 1] == 1) {
            points.add(new Point(point.x, point.y - 1));
        }

        if (point.y + 1 < n && matrix[point.x][point.y + 1] == 1) {
            points.add(new Point(point.x, point.y + 1));
        }

        return points;
    }

}
