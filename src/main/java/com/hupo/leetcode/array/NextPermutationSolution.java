package com.hupo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.hupo.leetcode.TreeNode;


public class NextPermutationSolution {
    public static void main(String[] args) {
        System.out.println(0 ^ 0);
        NextPermutationSolution solution = new NextPermutationSolution();
        int number = solution.missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 });
        System.out.println(number);

    }

    public int firstBadVersion(int n) {
        if (!isBadVersion(n)) {
            return 0;
        }
        int left = 1;
        int right = n;
        while (left < right) {
            long middle = (left + right) / 2;
            if (isBadVersion((int) middle)) {
                right = (int) middle - 1;
            } else {
                left = (int) middle + 1;
            }
        }
        return isBadVersion(right) ? right : right + 1;
    }

    public boolean isBadVersion(int version) {
        return true;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> leftPath = binaryTreePaths(root.left);
        List<String> rightPath = binaryTreePaths(root.right);
        if (leftPath == null && rightPath == null) {
            return Arrays.asList(Integer.toString(root.val));
        }
        List<String> allPaths = new ArrayList<>();
        if (leftPath != null) {
            for (String path : leftPath) {
                allPaths.add(root.val + "->" + path);
            }
        }
        if (rightPath != null) {
            for (String path : rightPath) {
                allPaths.add(root.val + "->" + path);
            }
        }
        return allPaths;
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        return false;
    }

    public int numJewelsInStones(String jewels, String stones) {
        if (jewels == null || jewels.length() == 0 || stones == null || stones.length() == 0) {
            return 0;
        }
        Set<Character> gemSet = new HashSet<>();
        for (int i = 0; i <= jewels.length() - 1; i++) {
            gemSet.add(jewels.charAt(i));
        }
        int result = 0;
        for (int i = 0; i <= stones.length() - 1; i++) {
            if (gemSet.contains(stones.charAt(i))) {
                result++;
            }
        }
        return result;
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            result = result ^ i ^ nums[i];
        }
        result = result ^ n;
        return result;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return null;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null && subRoot != null) {
            return false;
        }
        return treeNodeEquals(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right,
                subRoot);
    }

    public boolean treeNodeEquals(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        return treeNodeEquals(root.left, subRoot.left) && treeNodeEquals(root.right, subRoot.right);
    }

}
