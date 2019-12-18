package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumTree {


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
