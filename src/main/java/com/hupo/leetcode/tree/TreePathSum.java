package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreePathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> temp = new ArrayList<>();
                temp.add(root.val);
                result.add(temp);

                return result;
            }
        }

        if (root.left != null) {
            List<List<Integer>> leftResult = pathSum(root.left, sum - root.val);
            if (leftResult != null && leftResult.size() > 0) {
                result.addAll(preAppend(leftResult, root.val));
            }
        }

        if (root.right != null) {
            List<List<Integer>> rightResult = pathSum(root.right, sum - root.val);
            if (rightResult != null && rightResult.size() > 0) {
                result.addAll(preAppend(rightResult, root.val));
            }
        }

        return result;
    }


    private List<List<Integer>> preAppend(List<List<Integer>> list, Integer a) {

        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> item : list) {
            List<Integer> temp = new ArrayList<>();
            temp.add(a);
            temp.addAll(item);
            result.add(temp);
        }
        return result;

    }


    public static void main(String[] arg) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);

        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.right.left = new TreeNode(13);

        root.right.left = new TreeNode(4);


        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left.left = new TreeNode(5);
        root.right.left.right = new TreeNode(1);

        TreePathSum treePathSum = new TreePathSum();

        List<List<Integer>> result = treePathSum.pathSum(root, 22);

        System.out.println(result);

    }


}
