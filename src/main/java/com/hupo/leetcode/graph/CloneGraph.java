package com.hupo.leetcode.graph;


import java.util.*;

public class CloneGraph {

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        return recurseGraph(node, new HashMap<>());
    }

    public Node recurseGraph(Node node, Map<Node, Node> map) {

        Node currentNode = new Node();
        currentNode.val = node.val;

        currentNode.neighbors = new ArrayList<>();
        map.put(node, currentNode);

        if (node.neighbors != null) {
            for (Node next : node.neighbors) {
                if (map.containsKey(next)) {
                    currentNode.neighbors.add(map.get(next));
                } else {
                    currentNode.neighbors.add(recurseGraph(next, map));
                }
            }
        }

        return currentNode;
    }


}
