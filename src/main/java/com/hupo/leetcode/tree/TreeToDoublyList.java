package com.hupo.leetcode.tree;


import java.util.*;
import java.util.concurrent.BlockingQueue;

public class TreeToDoublyList {

    private static void main(String[] args) {
        System.out.println("123");
        TreeSet<String> set = new TreeSet<>();
        set.add("123");
        set.add("456");
        Collections.sort(new ArrayList<String>());

    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node left = root.left;
        Node right = root.right;
        Node node = treeToDoublyList(left);

        while (node != null && node.right != null) {
            node = node.right;
        }
        if (node != null) {
            node.right = root;
            root.left = node;
        }

        node = treeToDoublyList(right);

        if (node != null) {
            node.left = root;
            root.right = node;
        }

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}
