package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TreeWidth {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(1);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.left.left = new TreeNode(1);


        treeNode.right = new TreeNode(1);
        treeNode.right.right = new TreeNode(1);
        treeNode.right.right.right = new TreeNode(1);

        TreeWidth treeWidth = new TreeWidth();
        int width = treeWidth.widthOfBinaryTree(treeNode);

        System.out.println(width);
    }


    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Integer width = 1;

        Queue<TreeNodeIndex> queue = new ConcurrentLinkedQueue<>();
        queue.offer(new TreeNodeIndex(root, 0));

        while (!queue.isEmpty()) {

            Queue<TreeNodeIndex> tempQueue = new ConcurrentLinkedQueue<>();

            int left = queue.peek().index;

            int right = queue.peek().index;

            while (!queue.isEmpty()) {
                TreeNodeIndex treeNodeIndex = queue.poll();

                TreeNode node = treeNodeIndex.treeNode;
                if (node.left != null) {
                    tempQueue.offer(new TreeNodeIndex(node.left, (2 * treeNodeIndex.index) + 1));
                }
                if (node.right != null) {
                    tempQueue.offer(new TreeNodeIndex(node.right, (2 * treeNodeIndex.index) + 2));
                }

                right = treeNodeIndex.index;
            }

            int currentWidth = right - left + 1;

            if (currentWidth > width) {
                width = currentWidth;
            }

            queue = tempQueue;

        }

        return width;
    }


    /**
     * 参考完全二叉树的索引
     */
    public static class TreeNodeIndex {

        public TreeNode treeNode;

        public int index;

        public TreeNodeIndex(TreeNode treeNode, int index) {
            this.treeNode = treeNode;
            this.index = index;
        }

    }

}
