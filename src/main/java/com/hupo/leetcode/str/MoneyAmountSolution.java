package com.hupo.leetcode.str;

import java.util.HashMap;
import java.util.Map;


public class MoneyAmountSolution {

    public static class Item {
        public int amount;
        public int count;

        public Item(int amount, int count) {
            this.amount = amount;
            this.count = count;
        }

    }

    public Map<Integer, Item> map = new HashMap<>();

    public static void main(String[] args) {
        MoneyAmountSolution solution = new MoneyAmountSolution();
        System.out.println(solution.getMoneyAmount(1));
        System.out.println(solution.getMoneyAmount(2));
        System.out.println(solution.getMoneyAmount(3));
        System.out.println(solution.getMoneyAmount(4));
        System.out.println(solution.getMoneyAmount(5));
        System.out.println(solution.getMoneyAmount(6));
        System.out.println(solution.getMoneyAmount(7));
        System.out.println(solution.getMoneyAmount(8));
        System.out.println(solution.getMoneyAmount(9));
        System.out.println(solution.getMoneyAmount(10));
        System.out.println(solution.getMoneyAmount(18));
    }

    public int getMoneyAmount(int n) {
        for (int i = 1; i <= n; i++) {
            Item item = getMoneyAmountRange(1, i);
            map.put(i, item);
        }
        return map.get(n).amount;
    }

    public Item getMoneyAmountRange(int start, int end) {
        if (end <= start) {
            return new Item(0, 0);
        }
        if (start == end - 1) {
            return new Item(start, 1);
        }
        if (map.containsKey(end - start + 1)) {
            Item item = map.get(end - start + 1);
            Integer number = item.amount + (start - 1) * item.count;
            return new Item(number, item.count);
        }
        Item item = new Item(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (int i = start; i <= end; i++) {
            Item left = getMoneyAmountRange(start, i - 1);
            Item right = getMoneyAmountRange(i + 1, end);
            Item currentMax = new Item(Integer.MAX_VALUE, Integer.MAX_VALUE);
            if (left.amount >= right.amount) {
                currentMax.amount = left.amount + i;
                currentMax.count = left.count + 1;
            } else {
                currentMax.amount = right.amount + i;
                currentMax.count = right.count + 1;
            }
            if (currentMax.amount < item.amount) {
                item = currentMax;
            }
        }
        return item;
    }

}
