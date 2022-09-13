package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;


public class UnivalTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isUnivalTree(root, root.val);
    }

    public boolean isUnivalTree(TreeNode root, int value) {
        if (root == null) {
            return true;
        }
        if (root.val != value) {
            return false;
        }
        return isUnivalTree(root.left, value) && isUnivalTree(root.right, value);
    }
}
