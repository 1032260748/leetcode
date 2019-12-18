package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        Queue<TreeNode> swapQueue = new ConcurrentLinkedQueue<>();

        List<Integer> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left != null) {
                swapQueue.add(current.left);
            }
            if (current.right != null) {
                swapQueue.add(current.right);
            }

            if (queue.isEmpty()) {
                result.add(current.val);
                Queue<TreeNode> tempQueue = queue;
                queue = swapQueue;
                swapQueue = tempQueue;
            }
        }

        return result;
    }
}
