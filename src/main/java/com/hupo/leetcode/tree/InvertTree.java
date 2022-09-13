package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(23);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(1);
        List<Double> result = averageOfLevels(root);
        System.out.println(result);
    }


    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count, size;
            size = count = queue.size();
            int sum = 0;
            while (count > 0) {
                TreeNode treeNode = queue.poll();
                sum = sum + treeNode.val;
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                count--;
            }
            result.add(sum / (size * 1.0));
        }
        return result;
    }

    public boolean canWinNim(int n) {
        return !(n % 4 == 0);
    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode rightNew = invertTree(root.right);

        TreeNode leftNew = invertTree(root.left);

        root.left = rightNew;
        root.right = leftNew;
        return root;

    }
}
