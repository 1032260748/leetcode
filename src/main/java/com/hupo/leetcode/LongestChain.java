package com.hupo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestChain {

    public int findLongestChain(int[][] pairs) {

        if (pairs == null || pairs.length == 0) {
            return 0;
        }

        List<Node> nodeList = new ArrayList<>();

        for (int i = 0; i <= pairs.length - 1; i++) {
            int[] temp = pairs[i];
            nodeList.add(new Node(temp[0], temp[1]));
        }

        nodeList.sort((o1, o2) -> {
            if (o1.end < o2.end) {
                return -1;
            } else if (o1.end > o2.end) {
                return 1;
            } else {
                return Integer.compare(o1.start, o2.start);
            }
        });


        int count = 1;
        Node pre = nodeList.get(0);

        for (int i = 1; i <= nodeList.size() - 1; i++) {
            Node current = nodeList.get(i);
            if (current.start > pre.end) {
                count++;
                pre = current;
            }

        }

        return count;
    }

    public static class Node {
        public int start;
        public int end;

        public Node() {
        }

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {

        int[][] array = new int[4][2];

        array[0] = new int[]{1, 2};
        array[1] = new int[]{3, 4};
        array[2] = new int[]{2, 3};
        array[3] = new int[]{4, 6};

        LongestChain chain = new LongestChain();
        int count = chain.findLongestChain(array);
        System.out.println(count);
    }

}
