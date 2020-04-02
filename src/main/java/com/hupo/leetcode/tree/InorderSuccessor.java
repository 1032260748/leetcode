package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;

import java.util.Stack;

public class InorderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
            } else {
                TreeNode top = stack.pop();
                if (pre == p) {
                    return top;
                }
                if (top == p) {
                    pre = p;
                }
                current = top.right;
            }
        }
        return null;
    }
}
