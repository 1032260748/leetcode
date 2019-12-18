package com.hupo.leetcode.graph;

import java.util.*;

public class ValidTree {

    public static void main(String[] args) {
        int[][] edges = new int[4][2];
        edges[0] = new int[]{1, 4};
        edges[1] = new int[]{0, 2};
        edges[2] = new int[]{0, 3};
        edges[3] = new int[]{0, 1};

        boolean valid = (new ValidTree()).validTree(5, edges);
        System.out.println(valid);
    }


    public boolean validTree(int n, int[][] edges) {

        if (edges == null || edges.length == 0) {
            return true;
        }

        Map<Integer, Set<Integer>> map = handleList(edges);

        // write your code here
        Set<Integer> set = new HashSet<>();


        boolean valid = validTreeCur(-1, edges[0][0], map, set);
        return valid && set.size() == n;
    }


    private Map<Integer, Set<Integer>> handleList(int[][] edges) {

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i <= edges.length - 1; i++) {
            int[] temp = edges[i];
            int start = temp[0];
            int end = temp[1];
            handleEdge(map, start, end);
            handleEdge(map, end, start);
        }
        return map;
    }


    private void handleEdge(Map<Integer, Set<Integer>> map, int start, int end) {
        if (map.containsKey(start)) {
            map.get(start).add(end);
        } else {
            Set<Integer> tempList = new HashSet<>();
            tempList.add(end);
            map.put(start, tempList);
        }
    }

    private boolean validTreeCur(int parent, int current, Map<Integer, Set<Integer>> edges, Set<Integer> visited) {
        if (visited.contains(current)) {
            return false;
        }
        visited.add(current);
        Set<Integer> temp = edges.get(current);
        if (temp == null || temp.size() == 0) {
            return true;
        }

        for (int i : temp) {
            if (parent == i) {
                continue;
            }

            boolean valid = validTreeCur(current, i, edges, visited);
            if (!valid) {
                return false;
            }
        }
        return true;
    }


}
