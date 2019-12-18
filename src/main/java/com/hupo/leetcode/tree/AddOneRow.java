package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AddOneRow {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);

        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.left = new TreeNode(6);

        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);


        treeNode.right.left.left = new TreeNode(7);

        treeNode.right.right.left = new TreeNode(8);

        List<TreeNode> treeNodeList = new ArrayList<>();

        AddOneRow addOneRow = new AddOneRow();
        addOneRow.getNodes(treeNode, 2, treeNodeList);

        System.out.println(treeNodeList);

    }

    public void getNodes(TreeNode node, int n, List<TreeNode> arrayList) {
        if (n == 0 || node == null) {
            return;
        }
        if (n == 1) {
            arrayList.add(node);
            return;
        } else {
            if (node.left != null) {
                getNodes(node.left, n - 1, arrayList);
            }
            if (node.right != null) {
                getNodes(node.right, n - 1, arrayList);
            }
        }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode treeNode = new TreeNode(v);
            treeNode.left = root;
            return treeNode;
        }

        int i = 1;

        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        queue.offer(root);
        while (i <= d - 1) {
            Queue<TreeNode> tempQueue = new ConcurrentLinkedQueue<>();
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    tempQueue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    tempQueue.offer(treeNode.right);
                }
            }
            queue = tempQueue;
        }

        addNewNodes(queue, v);
        return root;
    }

    /**
     * 添加新节点
     *
     * @param queue
     * @param v
     */
    private void addNewNodes(Queue<TreeNode> queue, int v) {

        while (!queue.isEmpty()) {

            TreeNode treeNode = queue.poll();
            TreeNode originalLeft = treeNode.left;
            TreeNode originalRight = treeNode.right;

            if (originalLeft == null && originalRight == null) {

            }
            if (originalLeft != null) {
                TreeNode newLeft = new TreeNode(v);
                newLeft.left = originalLeft;
                treeNode.left = newLeft;
            }

            if (originalRight != null) {
                TreeNode newRight = new TreeNode(v);
                newRight.right = originalRight;
                treeNode.right = newRight;
            }
        }
    }

}
