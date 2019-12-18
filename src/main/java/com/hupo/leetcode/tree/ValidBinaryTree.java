package com.hupo.leetcode.tree;


import com.hupo.leetcode.TreeNode;

public class ValidBinaryTree {

    public static class Limit {

        public Integer max;

        public Integer min;

        public Limit(Integer max, Integer min) {
            this.max = max;
            this.min = min;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBsT(root, new Limit(null, null));
    }

    public boolean isValidBsT(TreeNode root, Limit limit) {
        if (root == null) {
            return true;
        }

        if (limit.min != null && root.val <= limit.min) {
            return false;
        }
        if (limit.max != null && root.val >= limit.max) {
            return false;
        }

        return isValidBsT(root.left, new Limit(root.val, limit.min)) && isValidBsT(root.right, new Limit(limit.max, root.val));
    }

}
