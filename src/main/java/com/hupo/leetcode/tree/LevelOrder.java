package com.hupo.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import com.hupo.leetcode.TreeNode;


public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = queue.size();
        while (!queue.isEmpty()) {

            int count = 0;

            List<Integer> temp = new ArrayList<>();

            while (count < size) {

                TreeNode treeNode = queue.poll();
                temp.add(treeNode.val);

                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }

                count++;
            }

            resultList.add(temp);
            size = queue.size();
        }

        return resultList;

    }
}
