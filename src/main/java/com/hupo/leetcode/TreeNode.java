package com.hupo.leetcode;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        ConcurrentLinkedDeque<TreeNode> queue = new ConcurrentLinkedDeque<>();
        ConcurrentLinkedDeque<TreeNode> temp = new ConcurrentLinkedDeque<>();

        queue.addLast(root);
        while (!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.peek();
                tempList.add(treeNode.val);

                if (treeNode.left != null) {
                    temp.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    temp.addLast(treeNode.right);
                }
                queue.removeFirst();
            }

            result.add(tempList);

            ConcurrentLinkedDeque<TreeNode> inner = temp;
            temp = queue;
            queue = inner;

        }

        return result;
    }

    private void swap(Stack<TreeNode> m, Stack<TreeNode> n) {
        Stack<TreeNode> temp = m;
        m = n;
        n = temp;
    }
}
