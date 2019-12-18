package com.hupo.leetcode;


public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {

        if (root == null) {
            return 0;
        }

        FindResult result = new FindResult();
        result.heigth = -1;
        result.value = -1;

        findBottomLeftValue(root, result, 1);

        return result.value;
    }


    public void findBottomLeftValue(TreeNode node, FindResult result, int height) {
        if (node == null) {
            return;
        }

        if (height > result.heigth) {
            result.heigth = height;
            result.value = node.val;
        }

        if (node.left != null) {
            findBottomLeftValue(node.left, result, height + 1);
        }

        if (node.right != null) {
            findBottomLeftValue(node.right, result, height + 1);
        }
    }


    public static class FindResult {

        public int heigth;

        public int value;

    }
}
