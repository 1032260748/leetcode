package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;


public class BstFromPreorder {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }

    public TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(preorder[start]);
        }

        TreeNode root = new TreeNode(preorder[start]);

        int leftEnd = -1;

        for (int i = start + 1; i <= end; i++) {

            if (preorder[i] < root.val) {
                leftEnd = i;
            } else {
                break;
            }
        }

        if (leftEnd > start) {
            root.left = bstFromPreorder(preorder, start + 1, leftEnd);
            root.right = bstFromPreorder(preorder, leftEnd + 1, end);
        } else {
            root.right = bstFromPreorder(preorder, start + 1, end);
        }

        return root;
    }

}
