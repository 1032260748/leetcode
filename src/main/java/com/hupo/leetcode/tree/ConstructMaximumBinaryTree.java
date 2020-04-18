package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;

public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode treeNode = new TreeNode(nums[maxIndex]);

        treeNode.left = constructMaximumBinaryTree(nums, start, maxIndex - 1);
        treeNode.right = constructMaximumBinaryTree(nums, maxIndex + 1, end);
        return treeNode;
    }

}
