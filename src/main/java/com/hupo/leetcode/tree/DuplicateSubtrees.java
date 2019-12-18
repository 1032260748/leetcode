package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        List<TreeNode> result = new ArrayList<>();
        Set<String> hashSet = new HashSet<>();

        getTreeString(root, hashSet, result);

        return result;
    }


    public String getTreeString(TreeNode root, Set<String> set, List<TreeNode> result) {
        if (root == null) {
            return "";
        }

        String left = getTreeString(root.left, set, result);
        String right = getTreeString(root.right, set, result);

        String currentPath = root.val + " l " + left + " r " + right;
        if (!set.contains(currentPath)) {
            set.add(currentPath);
            result.add(root);
        }

        return currentPath;
    }

}
