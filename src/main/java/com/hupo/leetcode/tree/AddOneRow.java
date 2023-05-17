package com.hupo.leetcode.tree;

import com.hupo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;


public class AddOneRow {

    public static class MyCircularQueue {

        private int maxSize;

        private int currentSize;

        private int front = 0;

        private int tail = -1;

        private int[] array;

        public MyCircularQueue(int k) {
            this.maxSize = k;
            this.array = new int[k];
        }

        public boolean enQueue(int value) {
            if (currentSize < maxSize) {
                tail = (tail + 1) % this.maxSize;
                this.array[tail] = value;
                this.currentSize++;
                return true;
            } else {
                return false;
            }
        }

        public boolean deQueue() {
            if (this.currentSize == 0) {
                return false;
            }
            this.array[front] = 0;
            front = (front + 1) % maxSize;
            this.currentSize--;
            return true;
        }

        public int Front() {
            if (this.currentSize == 0) {
                return -1;
            }
            return this.array[front];
        }

        public int Rear() {
            if (this.currentSize == 0) {
                return -1;
            }
            return this.array[tail];
        }

        public boolean isEmpty() {
            return currentSize == 0;
        }

        public boolean isFull() {
            return currentSize == maxSize;
        }
    }

    public int maxProfit(int[] prices, int fee) {
        int[][] dup = new int[prices.length][prices.length];
        for (int len = 1; len <= prices.length - 1; len++) {
            for (int i = 0; i <= prices.length - 1 && i + len <= prices.length - 1; i++) {
                dup[i][i + len] = Math.max(0, prices[i + len] - prices[i] - fee);
                for (int j = 1; j < len; j++) {
                    dup[i][i + len] = Math.max(dup[i][i + len], dup[i][i + j] + dup[i + j][i + len]);
                }
            }
        }
        return dup[0][prices.length - 1];
    }

    private int result = 0;

    public static class DicNode {
        public char current;

        public Map<Character, DicNode> nextMap = new HashMap<>();
    }

    public int minimumLengthEncoding(String[] words) {
        DicNode init = new DicNode();
        init.current = '#';

        for (int i = 0; i < words.length; i++) {
            DicNode dicNode = init;

            for (int j = words[i].length() - 1; j >= 0; j--) {
                Character currentChar = words[i].charAt(j);
                if (dicNode.nextMap.containsKey(currentChar)) {
                    dicNode = dicNode.nextMap.get(currentChar);
                } else {
                    DicNode nextNode = new DicNode();
                    dicNode.current = currentChar;
                    dicNode.nextMap.put(currentChar, nextNode);
                    dicNode = nextNode;
                }
            }
        }

        trans(init, 1);
        return result;
    }

    private void trans(DicNode dicNode, int len) {
        if (dicNode == null || dicNode.nextMap == null || dicNode.nextMap.size() == 0) {
            result = result + len;
            return;
        }

        for (Map.Entry<Character, DicNode> next : dicNode.nextMap.entrySet()) {
            trans(next.getValue(), len + 1);
        }
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.left == null) {
            return 1;
        }

        //todo
        return 0;
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {

        return null;

    }

    public String largestNumber(int[] nums) {
        String[] numbers = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(numbers, (str1, str2) ->
                {
                    if (str1.length() == str2.length()) {
                        return str1.compareTo(str2);
                    }
                    return (str1 + str2).compareTo(str2 + str1);
                }
        );

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = numbers.length - 1; i >= 0; i--) {
            stringBuffer.append(numbers[i]);
        }
        if (stringBuffer.charAt(0) == '0') {
            return "0";
        }
        return stringBuffer.toString();
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= maxChoosableInteger; i++) {
            list.add(i);
        }
        return canIWin(list, desiredTotal);
    }

    private boolean canIWin(List<Integer> list, int desitedTotal) {
        if (list.size() == 0) {
            return desitedTotal <= 0;
        }
        if (list.size() == 1) {
            return list.get(0) >= desitedTotal;
        }

        for (Integer i : list) {
            if (i >= desitedTotal) {
                return true;
            }
            boolean result = true;
            for (Integer j : list) {
                if (i == j) {
                    continue;
                }
                if (desitedTotal - i - j <= 0) {
                    result = false;
                    break;
                }
                result = result && canIWin(leftList(list, i, j), desitedTotal - i - j);
                if (!result) {
                    break;
                }
            }
            if (result) {
                return true;
            }

        }
        return false;
    }

    private List<Integer> leftList(List<Integer> list, int i, int j) {
        List<Integer> left = new ArrayList<>();
        for (Integer integer : list) {
            if (integer != i && integer != j) {
                left.add(integer);
            }
        }
        return left;
    }

    public int function(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * function(n - 1);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }

    public static int getSum(int a, int b) {
        int result = a ^ b;
        int flag = (a & b) << 1;
        while (flag != 0) {
            int temp = result;
            result = result ^ flag;
            flag = (temp & flag) << 1;
        }
        return result;
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (pre > 0) {
                int current = pre + nums[i];
                if (current > max) {
                    max = current;
                }
                pre = current;
            } else {
                int current = nums[i];
                if (current > max) {
                    max = current;
                }
                pre = current;
            }

        }

        return max;

    }

    private List<Edge> edges;

    public static class Edge {
        public Integer value;
        public Set<Integer> pre;
        public Set<Integer> to;

        public Edge() {

        }

        public Edge(int value) {
            this.value = value;
            this.pre = new HashSet<>();
            this.to = new HashSet<>();
        }

    }

    public int findDuplicate(int[] nums) {
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff = nums[i] - i - 1;
        }
        return nums.length + 1 + diff;
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int result = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] >= result + 1) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //todo
        return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //todo
        return null;
    }

    public static void main(String[] args) {
        AddOneRow addOneRow = new AddOneRow();
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };

        int[] result = null;
        System.out.println(result);
    }

    public void getNodes(TreeNode node, int n, List<TreeNode> arrayList) {
        if (n == 0 || node == null) {
            return;
        }
        if (n == 1) {
            arrayList.add(node);
            return;
        } else {
            if (node.left != null) {
                getNodes(node.left, n - 1, arrayList);
            }
            if (node.right != null) {
                getNodes(node.right, n - 1, arrayList);
            }
        }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode treeNode = new TreeNode(v);
            treeNode.left = root;
            return treeNode;
        }

        int i = 1;

        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        queue.offer(root);
        while (i <= d - 1) {
            Queue<TreeNode> tempQueue = new ConcurrentLinkedQueue<>();
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    tempQueue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    tempQueue.offer(treeNode.right);
                }
            }
            queue = tempQueue;
        }

        addNewNodes(queue, v);
        return root;
    }

    /**
     * 添加新节点
     *
     * @param queue
     * @param v
     */
    private void addNewNodes(Queue<TreeNode> queue, int v) {

        while (!queue.isEmpty()) {

            TreeNode treeNode = queue.poll();
            TreeNode originalLeft = treeNode.left;
            TreeNode originalRight = treeNode.right;

            if (originalLeft == null && originalRight == null) {

            }
            if (originalLeft != null) {
                TreeNode newLeft = new TreeNode(v);
                newLeft.left = originalLeft;
                treeNode.left = newLeft;
            }

            if (originalRight != null) {
                TreeNode newRight = new TreeNode(v);
                newRight.right = originalRight;
                treeNode.right = newRight;
            }
        }
    }

}
