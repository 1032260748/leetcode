package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;


public class SerializeTree {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        TempNode tempNode = deserialize(data, 0);
        return tempNode.node;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        SerializeTree serializeTree = new SerializeTree();
        String txt = serializeTree.serialize(treeNode);

        TreeNode newNode = serializeTree.deserialize(txt);

        String newTxt = serializeTree.serialize(newNode);
        System.out.println(txt.equals(newTxt));
    }

    public TempNode deserialize(String data, int index) {
        if (index < data.length() - 1) {

            String str = "";

            int leftStart = index;
            for (int i = index; i <= data.length(); i++) {
                if (data.charAt(i) == ',') {
                    leftStart = i + 1;
                    break;
                } else {
                    str = str + data.charAt(i);
                }
            }

            TempNode tempNode = new TempNode();

            if (str.length() == 0) {
                tempNode.index = leftStart;
                return tempNode;
            }
            TreeNode treeNode = new TreeNode(Integer.valueOf(str));
            tempNode.node = treeNode;

            TempNode leftTemp = deserialize(data, leftStart);

            TempNode rightTemp = deserialize(data, leftTemp.index);

            tempNode.index = rightTemp.index;

            treeNode.left = leftTemp.node;
            treeNode.right = rightTemp.node;

            return tempNode;
        } else {
            TempNode tempNode = new TempNode();
            tempNode.index = data.length();
            return tempNode;
        }

    }

    public static class TempNode {
        public int index;
        public TreeNode node;
    }

}
