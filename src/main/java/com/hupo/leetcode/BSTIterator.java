package com.hupo.leetcode;

import java.util.Stack;

public class BSTIterator {

    public Stack<TreeNode> stack = new Stack<>();


    public BSTIterator(TreeNode root) {
        pushToStack(root);
    }

    public void pushToStack(TreeNode current) {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode treeNode = stack.pop();
        pushToStack(treeNode.right);
        return treeNode.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
