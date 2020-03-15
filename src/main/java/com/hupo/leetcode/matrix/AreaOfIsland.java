package com.hupo.leetcode.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AreaOfIsland {

    public static void main(String[] args) {
        int[][] array = new int[4][5];
        array[0] = new int[]{1, 1, 0, 0, 0};
        array[1] = new int[]{1, 1, 0, 0, 0};
        array[2] = new int[]{0, 0, 0, 1, 1};
        array[3] = new int[]{0, 0, 0, 1, 1};
        AreaOfIsland island = new AreaOfIsland();
        int result = island.maxAreaOfIsland(array);

        System.out.println(result);
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int[][] visited = new int[grid.length][grid[0].length];
        int maxLength = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == 1) {
                    continue;
                }
                if (grid[i][j] == 0) {
                    continue;
                }
                maxLength = Math.max(length(grid, visited, i, j), maxLength);
            }
        }
        return maxLength;
    }

    private int length(int[][] grid, int[][] visit, int i, int j) {
        visit[i][j] = 1;
        int length = 0;
        visit[i][j] = 1;
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(i, j));
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            length++;
            List<Position> positions = getPosition(grid, visit, position.x, position.y);
            if (positions.size() > 0) {
                queue.addAll(positions);
            }
        }
        return length;
    }

    private List<Position> getPosition(int[][] grid, int[][] visited, int i, int j) {
        List<Position> positions = new ArrayList<>();
        if (i - 1 >= 0 && grid[i - 1][j] == 1 && visited[i - 1][j] == 0) {
            visited[i - 1][j] = 1;
            positions.add(new Position(i - 1, j));
        }
        if (i + 1 <= grid.length - 1 && grid[i + 1][j] == 1 && visited[i + 1][j] == 0) {
            visited[i + 1][j] = 1;
            positions.add(new Position(i + 1, j));
        }

        if (j - 1 >= 0 && grid[i][j - 1] == 1 && visited[i][j - 1] == 0) {
            visited[i][j - 1] = 1;
            positions.add(new Position(i, j - 1));
        }

        if (j + 1 <= grid[0].length - 1 && grid[i][j + 1] == 1 && visited[i][j + 1] == 0) {
            visited[i][j + 1] = 1;
            positions.add(new Position(i, j + 1));
        }
        return positions;
    }


    public static class Position {
        public int x;
        public int y;

        public Position() {

        }

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }


    public int numWays(int n) {

        if (n <= 0) {
            return 0;
        }

        if (n <= 2) {
            return n;
        }

        int first = 1;
        int last = 2;
        for (int i = 3; i <= n; i++) {
            int temp = (first + last) % 1000000007;

            first = last;
            last = temp;
        }

        return last;

    }
}
