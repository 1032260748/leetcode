package com.hupo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.hupo.leetcode.ListNode;


public class CombinationSum2 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left) == list.get(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= (citations.length - mid)) {
                right = mid;
            } else if (citations[mid] < (citations.length - mid)) {
                left = mid + 1;
            }
        }
        return citations[right] >= citations.length - right ?
                citations.length - right : 0;
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        Node current = head;
        while (current != null) {
            Node node = new Node(current.val);
            nodeMap.put(current, node);
            current = current.next;
        }
        current = head;
        while (current != null) {
            Node random = current.random;
            if (random != null) {
                nodeMap.get(current).random = nodeMap.get(random);
            }
            Node next = current.next;
            if (next != null) {
                nodeMap.get(current).next = nodeMap.get(next);
            }
            current = next;
        }
        return nodeMap.get(head);
    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, Integer> flowerMap = new HashMap<>();
        HashMap<Integer, Set<Integer>> routeMap = new HashMap<>();
        for (int i = 0; i < paths.length; i++) {
            Integer from = paths[i][0];
            Integer to = paths[i][1];
            if (routeMap.containsKey(from)) {
                routeMap.get(from).add(to);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(to);
                routeMap.put(from, set);
            }
            if (routeMap.containsKey(to)) {
                routeMap.get(to).add(from);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(from);
                routeMap.put(to, set);
            }
        }
        int[] result = new int[n];
        for (int i = 1; i <= n; i++) {
            Set<Integer> nebi = routeMap.get(i);
            if (nebi == null || nebi.size() == 0) {
                result[i - 1] = 1;
                flowerMap.put(i, 1);
            } else {
                Set<Integer> nearFlower = new HashSet<>();
                for (Integer near : nebi) {
                    if (flowerMap.containsKey(near)) {
                        nearFlower.add(flowerMap.get(near));
                    }
                }
                for (int flower = 1; flower <= 4; flower++) {
                    if (!nearFlower.contains(flower)) {
                        result[i - 1] = flower;
                        flowerMap.put(i, flower);
                        break;
                    }
                }
            }
        }
        return result;
    }

    public int minMoves(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        int result = 0;
        while (min < max) {
            min = max;
            result++;
            int oldMaxIndex = maxIndex;
            for (int i = 0; i < nums.length; i++) {
                if (i != oldMaxIndex) {
                    nums[i] = nums[i] + 1;
                }
                if (nums[i] < min) {
                    min = nums[i];
                }
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
        }
        return result;

    }

    public int minMoves2(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result + nums[i] - min;
        }
        return result;
    }

    Map<Integer, Integer> countSet = new HashMap<>();
    List<List<Integer>> ans = new ArrayList<>();
    private Integer target = 0;

    public static class Item {
        public Integer number;
        public Integer count;

        public Item(Integer number, Integer count) {
            this.number = number;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] arrays = new int[] { 14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16, 12, 31, 9, 9, 12, 34, 16, 25, 32, 8, 7, 30,
                12, 33, 20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17, 16, 8, 24, 12, 12, 28, 11, 33, 10,
                32, 22, 13, 34, 18, 12 };
        int[][] paths = new int[2][2];
        paths[0] = new int[] { 1, 2 };
        paths[1] = new int[] { 3, 4 };
        int[] result = combinationSum2.gardenNoAdj(4, paths);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        List<Integer> integers = new ArrayList<>();
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            int currentNumber = candidates[i];
            if (countSet.containsKey(currentNumber)) {
                countSet.put(currentNumber, countSet.get(currentNumber) + 1);
            } else {
                countSet.put(currentNumber, 1);
                integers.add(currentNumber);
            }
        }
        trans(integers, 0, 0, new ArrayList<>());
        return this.ans;
    }

    public void trans(List<Integer> numbers, int con, int preNum, List<Item> pres) {
        Integer currentNumber = numbers.get(con);
        Integer numberCount = countSet.get(currentNumber);
        for (int i = 0; i <= numberCount; i++) {
            pres.add(new Item(currentNumber, i));
            preNum += currentNumber * i;
            if (preNum < this.target) {
                if (con < numbers.size() - 1) {
                    trans(numbers, con + 1, preNum, pres);
                } else {
                    if (preNum == this.target) {
                        ans.add(getAnswer(pres));
                    }
                }
            } else if (preNum == this.target) {
                ans.add(getAnswer(pres));
            }
            pres.remove(pres.size() - 1);
            preNum -= currentNumber * i;
        }
    }

    private List<Integer> getAnswer(List<Item> pres) {
        List<Integer> result = new ArrayList<>();
        for (Item item : pres) {
            for (int i = 1; i <= item.count; i++) {
                result.add(item.number);
            }
        }
        return result;
    }

}
