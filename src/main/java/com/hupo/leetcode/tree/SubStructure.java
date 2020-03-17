package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;

public class SubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean helper(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }

        return A.val == B.val && helper(A.left, B.left) && helper(A.right, B.right);
    }
}
