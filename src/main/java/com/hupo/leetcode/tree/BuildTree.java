package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;


public class BuildTree {

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        TreeNode treeNode = buildTree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }

    public TreeNode buildTree(int[] preoroder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preoroder[preStart]);
        }

        TreeNode current = new TreeNode(preoroder[preStart]);


        int splitIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preoroder[preStart]) {
                splitIndex = i;
                break;
            }
        }

        int leftSize = splitIndex - inStart;

        int rightSize = inEnd - splitIndex;

        current.left = buildTree(preoroder, inorder, preStart + 1, preStart + leftSize,
                inStart, splitIndex - 1);
        current.right = buildTree(preoroder, inorder, preEnd - rightSize + 1, preEnd,
                splitIndex + 1, inEnd);
        return current;
    }


    public void recoverTree(TreeNode root) {

        if (root == null) {
            return;
        }

        return;


    }

    public TempResult transInner(TreeNode treeNode) {
        TempResult tempResult = new TempResult();
        if (treeNode == null) {
            return new TempResult();
        }

        tempResult.min = treeNode;
        tempResult.max = treeNode;
        if (treeNode.left == null && treeNode.right == null) {
            return tempResult;
        }


        if (treeNode.left != null) {
            TempResult leftResult = transInner(treeNode.left);
            if (leftResult.max.val > treeNode.val) {
                int temp = leftResult.max.val;
                leftResult.max.val = treeNode.val;
                treeNode.val = temp;
            }

            tempResult.min = leftResult.min;
        }
        if (treeNode.right != null) {
            TempResult rightResult = transInner(treeNode.left);
            if (rightResult.min.val < treeNode.val) {
                int temp = rightResult.min.val;
                rightResult.min.val = treeNode.val;
                treeNode.val = temp;
            }

            tempResult.max = rightResult.max;
        }

        return tempResult;
    }

    public static class TempResult {
        public TreeNode min;
        public TreeNode max;
    }
}
