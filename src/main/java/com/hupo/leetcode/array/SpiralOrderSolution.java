package com.hupo.leetcode.array;

import java.util.ArrayList;
import java.util.List;


public class SpiralOrderSolution {

    public enum Direction {
        UP,
        RIGHT,
        LEFT,
        DOWN;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        Direction direction = Direction.RIGHT;
        int currentRow = 0;
        int currentColumn = 0;
        while (currentRow >= top && currentRow <= bottom && currentColumn >= left && currentColumn <= right) {
            result.add(matrix[currentRow][currentColumn]);
            if (direction == Direction.RIGHT) {
                if (currentColumn == right) {
                    direction = Direction.DOWN;
                    top = top + 1;
                    currentRow = currentRow + 1;
                } else {
                    currentColumn = currentColumn + 1;
                }
            } else if (direction == Direction.DOWN) {
                if (currentRow == bottom) {
                    direction = Direction.LEFT;
                    right = right - 1;
                    currentColumn = currentColumn - 1;
                } else {
                    currentRow = currentRow + 1;
                }
            } else if (direction == Direction.LEFT) {
                if (currentColumn == left) {
                    direction = Direction.UP;
                    bottom = bottom - 1;
                    currentRow = currentRow - 1;
                } else {
                    currentColumn = currentColumn - 1;
                }
            } else if (direction == Direction.UP) {
                if (currentRow == top) {
                    direction = Direction.RIGHT;
                    left = left + 1;
                    currentColumn = currentColumn + 1;
                } else {
                    currentRow = currentRow - 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        matrix[0] = new int[] { 1, 2, 3, 4 };
        matrix[1] = new int[] { 5, 6, 7, 8 };
        matrix[2] = new int[] { 9, 10, 11, 12 };
        SpiralOrderSolution solution = new SpiralOrderSolution();
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println(result);
    }
}
