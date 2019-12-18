package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;

public class FlattenTree {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        flatten(leftNode);
        flatten(rightNode);

        root.left = null;

        if (leftNode != null) {

            TreeNode current = leftNode;
            while (current.right != null) {
                current = current.right;
            }

            current.right = rightNode;

            root.right = leftNode;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;

        left.left = new TreeNode(5);
        left.right = new TreeNode(6);

        right.right = new TreeNode(8);

        FlattenTree flattenTree = new FlattenTree();

        flattenTree.flatten(root);

        System.out.println(root);
    }

}
