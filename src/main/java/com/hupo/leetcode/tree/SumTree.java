package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;

public class SumTree {


    public boolean isBalanced(TreeNode root) {
        BalanceResult result = recurBalance(root);
        return result.isBalance;
    }

    public BalanceResult recurBalance(TreeNode root) {

        if (root == null) {
            return new BalanceResult(true, 0);
        }

        BalanceResult leftResult = recurBalance(root.left);
        BalanceResult rightResult = recurBalance(root.right);

        int height = Math.max(leftResult.height, rightResult.height) + 1;

        if (!leftResult.isBalance || !rightResult.isBalance) {
            return new BalanceResult(false, height);
        } else {
            return new BalanceResult(Math.abs(leftResult.height - rightResult.height) <= 1, height);
        }
    }

    public static class BalanceResult {
        public boolean isBalance;
        public int height;

        public BalanceResult() {

        }

        public BalanceResult(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }


    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<String> integerList = subNumbersList(root);

        int sum = 0;

        for (String integer : integerList) {
            sum = sum + Integer.parseInt(integer);
        }
        return sum;
    }


    public List<String> subNumbersList(TreeNode root) {

        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            result.add(Integer.toString(root.val));
            return result;
        }

        if (root.left != null) {
            List<String> leftList = subNumbersList(root.left);
            result.addAll(appendHead(leftList, root.val));
        }

        if (root.right != null) {
            List<String> rightList = subNumbersList(root.right);
            result.addAll(appendHead(rightList, root.val));
        }

        return result;
    }


    private List<String> appendHead(List<String> list, int head) {
        List<String> integers = new ArrayList<>();

        if (list != null && list.size() > 0) {
            for (String integer : list) {
                integers.add(head + "" + integer);
            }
        } else {
            integers.add(Integer.toString(head));
        }
        return integers;
    }

    public static void main(String[] arg) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(0);

        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(1);

        SumTree sumTree = new SumTree();
        int sum = sumTree.sumNumbers(treeNode);
        System.out.println(sum);
    }


}
