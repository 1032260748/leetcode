package com.hupo.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import com.hupo.leetcode.TreeNode;


public class ZigzagLevelOrder {

    public static void main(String[] args) {
        ZigzagLevelOrder order = new ZigzagLevelOrder();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = order.zigzagLevelOrder(root);
        System.out.println(result);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        List<List<Integer>> result = new ArrayList<>();
        int flag = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> resultItem = new ArrayList<>();
            for (int i = 1; i <= size; i++) {
                TreeNode current;
                if (flag == 1) {
                    current = queue.removeLast();
                    if (current.right != null) {
                        queue.addFirst(current.right);
                    }
                    if (current.left != null) {
                        queue.addFirst(current.left);
                    }
                } else {
                    current = queue.removeFirst();
                    if (current.left != null) {
                        queue.addLast(current.left);
                    }
                    if (current.right != null) {
                        queue.addLast(current.right);
                    }
                }
                resultItem.add(current.val);
            }
            result.add(resultItem);
            flag = flag * (-1);
        }
        return result;
    }
}
