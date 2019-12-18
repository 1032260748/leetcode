package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        return "{" + root.val + serialize(root.left) + serialize(root.right) + "}";
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() <= 2) {
            return null;
        }

        String subString = data.substring(1, data.length() - 1);

        int index = subString.indexOf("{");

        int lastIndex = index + 1;

        Stack<String> stack = new Stack<>();

        stack.push("{");

        for (int i = index + 1; i < subString.length() - 1; i++) {

            if (subString.charAt(i) == '{') {
                stack.push("{");
            }
            if (subString.charAt(i) == '}') {
                stack.pop();
            }

            if (stack.isEmpty()) {
                lastIndex = i;
                break;
            }
        }

        TreeNode treeNode = new TreeNode(Integer.parseInt(subString.substring(0, index)));


        String leftNode = subString.substring(index, lastIndex + 1);
        String rightNode = subString.substring(lastIndex + 1);

        treeNode.left = deserialize(leftNode);
        treeNode.right = deserialize(rightNode);

        return treeNode;
    }


    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }


}
