package com.hupo.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;


public class AllOne {

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        String result = allOne.removeDuplicateLetters("bcabc");
        System.out.println(result);
    }

    public String removeDuplicateLetters(String s) {
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 1; i++) {
            Character c = s.charAt(i);
            map.putIfAbsent(c, new TreeSet<>());
            map.get(c).add(i);
        }
        Stack<Character> stack = new Stack<>();
        Set<Character> inStack = new HashSet<>();
        for (int i = 0; i <= s.length() - 1; i++) {
            Character c = s.charAt(i);
            if (inStack.contains(c)) {
                continue;
            }
            if (stack.isEmpty()) {
                stack.push(c);
                inStack.add(c);
                continue;
            }
            if (stack.peek() < c) {
                stack.push(c);
                inStack.add(c);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c) {
                if (i < map.get(stack.peek()).last()) {
                    inStack.remove(stack.peek());
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(c);
            inStack.add(c);
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }


    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }

        int size = length(head);
        if (size <= 1) {
            return head;
        }

        int current = 1;
        ListNode middle = head;
        while (current < size / 2 && middle.next != null) {
            middle = middle.next;
            current++;
        }

        ListNode second = middle.next;
        middle.next = null;

        ListNode firstSort = sortList(head);
        ListNode secondSort = sortList(second);

        return merge(firstSort, secondSort);
    }

    private ListNode merge(ListNode firstSort, ListNode secondSort) {
        if (firstSort == null) {
            return secondSort;
        }
        if (secondSort == null) {
            return firstSort;
        }

        ListNode firstCurrent = firstSort;
        ListNode secondCurrent = secondSort;

        ListNode current;
        ListNode newHead;

        if (firstCurrent.val <= secondCurrent.val) {
            current = firstCurrent;
            firstCurrent = firstCurrent.next;
        } else {
            current = secondCurrent;
            secondCurrent = secondCurrent.next;
        }
        current.next = null;
        newHead = current;

        while (firstCurrent != null && secondCurrent != null) {
            if (firstCurrent.val <= secondCurrent.val) {
                current.next = firstCurrent;
                firstCurrent = firstCurrent.next;
            } else {
                current.next = secondCurrent;
                secondCurrent = secondCurrent.next;
            }
            current = current.next;
            current.next = null;
        }

        if (secondCurrent != null) {
            current.next = secondCurrent;
        }

        if (firstCurrent != null) {
            current.next = firstCurrent;
        }
        return newHead;
    }

    private int length(ListNode head) {
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return 1;
        }
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size = size + 1;
            current = current.next;
        }
        return size;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 1; i <= size; i++) {
                Node current = queue.poll();
                level.add(current.val);

                if (current.children != null && !current.children.isEmpty()) {
                    for (Node child : current.children) {
                        queue.offer(child);
                    }
                }
            }
            result.add(level);
        }
        return result;
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        Arrays.fill(row, Integer.MIN_VALUE);
        Arrays.fill(col, Integer.MIN_VALUE);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }

        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum = sum + Math.min(row[i], col[j]) - grid[i][j];
            }
        }

        return sum;
    }

    public int longestDecomposition(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        for (int i = 1, n = s.length(); i <= n / 2; ++i) // 枚举前后缀长度
            if (s.substring(0, i).equals(s.substring(n - i))) // 立刻分割
                return 2 + longestDecomposition(s.substring(i, n - i));
        return 1; // 无法分割
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode current = root;
        while (current != null) {
            if (current.val == val) {
                return current;
            } else if (current.val > val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    Map<String, LinkNode> map;

    LinkNode head;

    LinkNode tail;

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        map = new HashMap<>();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        if (!map.containsKey(key)) {
            LinkNode linkNode = new LinkNode();
            linkNode.key = key;
            linkNode.value = 1;
            linkNode.pre = tail;

            if (tail != null) {
                tail.next = linkNode;
            }
            tail = linkNode;
            if (head == null) {
                head = tail;
            }
            map.put(key, linkNode);
        } else {
            LinkNode currentNode = map.get(key);
            currentNode.value = currentNode.value + 1;

            upShift(currentNode);
        }
    }

    public void upShift(LinkNode node) {
        if (node.pre == null) {
            head = node;
            return;
        }
        if (node.pre.value >= node.value) {
            return;
        }

        LinkNode pre = node.pre;
        LinkNode prePre = pre.pre;
        LinkNode next = node.next;

        //当前节点是尾节点
        pre.next = next;
        if (next == null) {
            tail = pre;
        } else {
            next.pre = pre;
        }
        pre.pre = node;
        node.next = pre;
        node.pre = prePre;
        if (prePre != null) {
            prePre.next = node;
        }

        upShift(node);
    }

    public void downShift(LinkNode node) {
        if (node.next == null) {
            tail = node;
            return;
        }
        if (node.next.value <= node.value) {
            return;
        }

        LinkNode next = node.next;
        LinkNode nextNext = next.next.next;
        LinkNode pre = node.pre;

        //当前节点是头节点
        next.pre = pre;
        if (pre == null) {
            head = next;
        } else {
            pre.next = next;
        }
        next.next = node;
        node.pre = next;
        node.next = nextNext;
        if (nextNext != null) {
            nextNext.pre = node;
        }

        downShift(node);
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        LinkNode currentNode = map.get(key);
        if (currentNode == null) {
            return;
        }
        //删除节点
        if (currentNode.value == 1) {
            map.remove(key);
            //如果是头节点
            if (head == currentNode) {
                if (currentNode.next != null) {
                    currentNode.next.pre = null;
                    head = currentNode.next;
                } else {
                    head = null;
                    tail = null;
                }
            } else if (tail == currentNode) {
                if (currentNode.pre != null) {
                    currentNode.pre.next = null;
                    tail = currentNode.pre;
                } else {
                    head = null;
                    tail = null;
                }
            } else {
                LinkNode pre = currentNode.pre;
                LinkNode next = currentNode.next;

                pre.next = next;
                next.pre = pre;
            }

            currentNode.pre = null;
            currentNode.next = null;
        } else {
            //移动节点
            currentNode.value = currentNode.value - 1;
            downShift(currentNode);
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        if (head != null) {
            return head.key;
        } else {
            return "";
        }
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        if (tail != null) {
            return tail.key;
        } else {
            return "";
        }
    }

    public static class LinkNode {
        public String key;
        public Integer value;
        public LinkNode pre;
        public LinkNode next;
    }
}
