package com.hupo.leetcode.link;

import com.hupo.leetcode.TreeNode;

import java.util.Arrays;

public class GetDecimalValue {

    private int count = 0;

    private int mod = (int) Math.pow(10, 9) + 7;

    public static void main(String[] args) {
        GetDecimalValue getDecimalValue = new GetDecimalValue();
        int count = getDecimalValue.checkRecord(100);
        System.out.println(count);
    }

    int M = 1000000007;

    public int checkRecord(int n) {
        int length = Math.max(n, 4);
        int[] f = new int[length + 1];
        f[0] = 1;
        f[1] = 2;
        f[2] = 4;
        f[3] = 7;

        for (int i = 4; i <= n; i++) {
            f[i] = (2 * f[i - 1] - f[i - 4]) % M;
        }

        int sum = f[n];
        for (int i = 1; i <= n; i++) {
            sum += (f[i - 1] * f[n - i]) % M;
        }
        return sum % M;
    }

    public int[] sortedSquares(int[] A) {

        for (int i = 0; i < A.length; i++) {
            A[i] = Math.abs(A[i]);
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        return A;
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = m - 1;
        int b = n - 1;

        int newIndex = m + n - 1;
        while (a >= 0 && b >= 0) {
            if (nums1[a] >= nums2[b]) {
                nums1[newIndex] = nums1[a];
                a--;
            } else {
                nums1[newIndex] = nums2[b];
                b--;
            }
            newIndex--;
        }
        while (b >= 0) {
            nums1[newIndex--] = nums2[b--];
        }
    }


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        TreeNode newNode = new TreeNode(t1.val + t2.val);

        newNode.left = mergeTrees(t1.left, t2.left);
        newNode.right = mergeTrees(t1.right, t2.right);
        return newNode;
    }

    public String stoneGameIII(int[] stoneValue) {
        int[] dp = new int[stoneValue.length + 3];
        int sum = 0;
        for (int n = stoneValue.length, i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MIN_VALUE;
            sum += stoneValue[i];
            for (int j = 1; j <= 3; j++) {
                dp[i] = Math.max(dp[i], sum - dp[i + j]);
            }
        }
        if (sum - dp[0] == dp[0]) {
            return "Tie";
        } else if (sum - dp[0] > dp[0]) {
            return "Bob";
        }
        return "Alice";
    }


    public int getDecimalValue(ListNode head) {
        int sum = 0;

        ListNode current = head;
        while (current != null) {
            sum = sum * 2 + current.val;
            current = current.next;
        }
        return sum;

    }
}
