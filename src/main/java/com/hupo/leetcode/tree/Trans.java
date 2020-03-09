package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Trans {

    public List<Integer> preorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                result.add(current.val);
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                current = current.right;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);


        Trans trans = new Trans();
        List<Integer> result = trans.postorderTraversal(treeNode);
        System.out.println(result);
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        List<Integer> result = new ArrayList<>();

        TreeNode lastVisit = null;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.peek();
                if (current.right != null) {
                    if (lastVisit == current.right) {
                        result.add(current.val);
                        stack.pop();
                        lastVisit = current;
                        current = null;
                    } else {
                        current = current.right;
                    }
                } else {
                    if (current.left == null || lastVisit == current.left) {
                        result.add(current.val);
                        stack.pop();
                        lastVisit = current;
                        current = null;
                    }
                }

            }
        }
        return result;
    }
}
