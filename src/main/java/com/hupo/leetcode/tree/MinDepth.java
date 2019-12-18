package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;

public class MinDepth {

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.right == null) {
            return 1 + minDepth(root.left);
        } else if (root.left == null) {
            return 1 + minDepth(root.right);
        } else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }
}
