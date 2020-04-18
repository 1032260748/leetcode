package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;

import java.util.Stack;

public class ConvertBiNode {

    public static void main(String[] args) {
        int[] push = new int[]{1, 0};
        int[] pop = new int[]{1, 0};
        boolean result = validateStackSequences(push, pop);
        System.out.println(result);
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || pushed.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(pushed[0]);
        int pushIndex = 1;
        int poppedIndex = 0;
        while (poppedIndex < popped.length) {
            if (!stack.isEmpty() && popped[poppedIndex] == stack.peek()) {
                stack.pop();
                poppedIndex++;
            } else if (pushIndex < pushed.length) {
                stack.push(pushed[pushIndex]);
                pushIndex++;
            } else {
                break;
            }
        }
        return stack.isEmpty();
    }

    public static class TempNode {

        public TreeNode treeNode;
        public int height;

        public TempNode() {
        }

        public TempNode(TreeNode node, int height) {
            this.treeNode = node;
            this.height = height;
        }
    }


    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return height(root).treeNode;
    }

    private TempNode height(TreeNode root) {
        if (root == null) {
            return new TempNode(null, 0);
        }

        TempNode leftTempNode = height(root.left);
        TempNode rightTempNode = height(root.right);

        int newHeight = Math.max(leftTempNode.height, rightTempNode.height) + 1;

        if (leftTempNode.height == rightTempNode.height) {
            return new TempNode(root, newHeight);
        } else if (leftTempNode.height > rightTempNode.height) {
            return new TempNode(leftTempNode.treeNode, newHeight);
        } else {
            return new TempNode(rightTempNode.treeNode, newHeight);
        }
    }

    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = root.left;
        root.left = null;
        TreeNode right = root.right;
        root.right = null;

        TreeNode newHead = convertBiNode(leftNode);
        root.right = convertBiNode(right);
        if (newHead == null) {
            return root;
        } else {
            TreeNode current = newHead;
            while (current.right != null) {
                current = current.right;
            }
            current.right = root;
            return newHead;
        }

    }
}
