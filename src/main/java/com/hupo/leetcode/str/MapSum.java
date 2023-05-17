package com.hupo.leetcode.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MapSum {

    private Map<String, Integer> map = new HashMap<>();

    public DicNode initNode = new DicNode();

    public static class DicNode {
        public String key;
        public boolean finish;

        public Map<Character, DicNode> next = new HashMap<>();
    }

    private void insertDicNode(String str) {
        DicNode pre = initNode;
        for (int i = 0; i < str.length(); i++) {
            DicNode currentNode;
            Character curChar = str.charAt(i);
            if (pre.next.containsKey(curChar)) {
                currentNode = pre.next.get(curChar);
            } else {
                currentNode = new DicNode();
                pre.next.put(curChar, currentNode);
            }
            pre = currentNode;
            if (i == str.length() - 1) {
                currentNode.finish = true;
                currentNode.key = str;
            }
        }
    }

    private List<String> getKeys(String prefix) {
        DicNode pre = initNode;
        for (int i = 0; i <= prefix.length() - 1; i++) {
            if (pre.next.containsKey(prefix.charAt(i))) {
                pre = pre.next.get(prefix.charAt(i));
            } else {
                return new ArrayList<>();
            }
        }

        List<String> kes = new ArrayList<>();
        trans(pre, kes);
        return kes;
    }

    private void trans(DicNode dicNode, List<String> keys) {
        if (dicNode == null) {
            return;
        }
        if (dicNode.finish) {
            keys.add(dicNode.key);
        }
        if (dicNode.next != null && dicNode.next.size() > 0) {
            for (Map.Entry<Character, DicNode> entry : dicNode.next.entrySet()) {
                trans(entry.getValue(), keys);
            }
        }

    }

    public MapSum() {
        if (map == null) {
            map = new HashMap<>();
        }
    }

    public void insert(String key, int val) {
        if (map.containsKey(key)) {
            map.put(key, val);
        } else {
            map.put(key, val);
            insertDicNode(key);
        }

    }

    public int sum(String prefix) {
        List<String> keys = getKeys(prefix);
        if (keys == null || keys.size() == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            sum = map.get(key) + sum;

        }
        return sum;
    }
}
