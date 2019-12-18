package com.hupo.leetcode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HasRoute {

    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        Set<Integer> set = new HashSet<>();
        return hasRouteCur(set, s, t);
    }

    public boolean hasRouteCur(Set<Integer> visited, DirectedGraphNode s, DirectedGraphNode t) {
        if (s == t || Objects.equals(s.label, t.label)) {
            return true;
        }

        if (s == null) {
            return false;
        }

        visited.add(s.label);

        for (DirectedGraphNode directedGraphNode : s.neighbors) {
            if (visited.contains(directedGraphNode.label)) {
                continue;
            }
            if (hasRouteCur(visited, directedGraphNode, t)) {
                return true;
            }
        }
        return false;
    }

}
