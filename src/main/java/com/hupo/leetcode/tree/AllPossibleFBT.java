package com.hupo.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hupo.leetcode.TreeNode;


public class AllPossibleFBT {

    public List<TreeNode> allPossibleFBT(int N) {
        Map<Integer, List<TreeNode>> nodeMap = new HashMap<Integer, List<TreeNode>>();
        for (int i = 1; i <= N; i++) {
            List<TreeNode> nodeList = new ArrayList<TreeNode>();
            if (i == 1) {
                nodeList.add(new TreeNode(0));
            } else {

                for (int left = 1; i - left - 1 > 0; left++) {

                    int right = i - left - 1;
                }

            }

            nodeMap.put(i, nodeList);
        }
        return nodeMap.get(N);
    }
}
