package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 判断是不是完全二叉树
 */
public class CompleteTree {


    public static class TempResult {
        public int height;
        public int length;
    }


    public int diameterOfBinaryTree(TreeNode root) {
        TempResult tempResult = diameterOfBinaryTreeInner(root);
        return tempResult.length;
    }

    public TempResult diameterOfBinaryTreeInner(TreeNode root) {

        if (root == null) {
            return new TempResult();
        }

        TempResult leftResult = diameterOfBinaryTreeInner(root.left);
        TempResult rightResult = diameterOfBinaryTreeInner(root.right);

        TempResult current = new TempResult();
        current.height = Math.max(leftResult.height, rightResult.height) + 1;


        current.length = Math.max(Math.max(leftResult.length, rightResult.length), leftResult.height + rightResult.height);
        return current;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        Queue<TreeNode> nextLevel = new ConcurrentLinkedQueue<>();
        queue.add(root);

        boolean loss = false;

        while (!loss) {
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.remove();
                if (treeNode.left == null) {
                    loss = true;
                } else {
                    if (loss) {
                        return false;
                    } else {
                        nextLevel.add(treeNode.left);
                    }
                }
                if (treeNode.right == null) {
                    loss = true;
                } else {
                    if (loss) {
                        return false;
                    } else {
                        nextLevel.add(treeNode.right);
                    }
                }
            }

            if (!loss) {
                Queue<TreeNode> temp = nextLevel;
                nextLevel = queue;
                queue = temp;
            }
        }

        if (nextLevel.isEmpty()) {
            return true;
        }
        while (!nextLevel.isEmpty()) {
            TreeNode head = nextLevel.remove();
            if (head.left != null || head.right != null) {
                return false;
            }
        }

        return true;
    }
}
