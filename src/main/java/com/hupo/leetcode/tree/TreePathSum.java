package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> arrayList = new ArrayList<>();
        if (start > end) {
            arrayList.add(null);
            return arrayList;
        }
        if (start == end) {
            arrayList.add(new TreeNode(start));
            return arrayList;
        }


        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);
            for (int m = 0; m <= left.size() - 1; m++) {
                for (int n = 0; n <= right.size() - 1; n++) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left.get(m);
                    treeNode.right = right.get(n);
                    arrayList.add(treeNode);
                }
            }
        }
        return arrayList;
    }

    public boolean isValid(String s) {
        if (s == null || s.length() <= 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        stack.push(chars[0]);

        for (int i = 1; i <= chars.length - 1; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                stack.push(chars[i]);
            } else if (chars[i] == ')' || chars[i] == '}' || chars[i] == ']') {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if (top != getPair(chars[i])) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private char getPair(char temp) {
        switch (temp) {
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            default:
                throw new IllegalArgumentException();
        }
    }


}
