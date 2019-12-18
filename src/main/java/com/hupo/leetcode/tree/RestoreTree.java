package com.hupo.leetcode.tree;

import com.hupo.leetcode.ListNode;
import com.hupo.leetcode.TreeNode;

/**
 * 通过前序遍历和后序遍历顺序 确定不了 唯一的
 */
public class RestoreTree {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        return constructFromPrePost(pre, 0, post, post.length - 1, post.length);
    }

    public TreeNode constructFromPrePost(int[] pre, int preIndex, int[] post, int postIndex, int length) {
        if (length == 1) {
            return new TreeNode(pre[preIndex]);
        } else {
            TreeNode treeNode = new TreeNode(pre[preIndex]);
            if (preIndex + 1 <= pre.length - 1) {
                if (pre[preIndex + 1] == post[postIndex - 1]) {
                    treeNode.left = constructFromPrePost(pre, preIndex + 1, post, postIndex - 1, length - 1);
                } else {
                    int rightLength = 1;
                    for (int i = 1; i < length; i++) {
                        if (post[postIndex - i] == pre[preIndex + 1]) {
                            rightLength = i - 1;
                            break;
                        }
                    }

                    int leftLength = length - 1 - rightLength;
                    treeNode.left = constructFromPrePost(pre, preIndex + 1, post, postIndex - rightLength - 1, leftLength);
                    treeNode.right = constructFromPrePost(pre, preIndex + leftLength + 1, post, postIndex - 1, rightLength);
                }
            }

            return treeNode;
        }
    }

    public static class TreeMaxDeep {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

        }


        public int largestRectangleArea(int[] heights) {
            int[] result = new int[heights.length];
            for (int i = 0; i <= heights.length - 1; i++) {
                result[i] = heights[i];
            }
            for (int i = 0; i <= heights.length - 1; i++) {

                int min = heights[i];
                for (int j = i + 1; j <= heights.length - 1; j++) {

                    if (heights[j] <= min) {
                        min = heights[j];
                    }

                    int temp = min * (j - i + 1);
                    if (temp > result[i]) {
                        result[i] = temp;
                    }
                }
            }

            int max = result[0];
            for (int i = 0; i <= result.length - 1; i++) {
                if (result[i] > max) {
                    max = result[i];
                }
            }
            return max;
        }


        public ListNode mergeKLists(ListNode[] lists) {

            if (lists == null || lists.length == 0) {
                return null;
            }

            if (lists.length == 1) {
                return lists[0];
            }

            ListNode merge = lists[0];
            for (int i = 1; i <= lists.length - 1; i++) {
                merge = mergeTwoLists(merge, lists[i]);
            }
            return merge;
        }


        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }

        }


        public boolean isSameTree(TreeNode p, TreeNode q) {

            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }

            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        }


    }
}
