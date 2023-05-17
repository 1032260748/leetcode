package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;


public class SthSmallestSolution {

    private int k;

    private int currentCount = 0;

    private int value = 0;

    private boolean find = false;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        trans(root);
        return this.value;
    }

    private void trans(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            trans(root.left);
        }
        this.currentCount++;
        if (this.currentCount == k) {
            this.find = false;
            this.value = root.val;
            return;
        }
        if (root.right != null) {
            trans(root.right);
        }
    }
}
