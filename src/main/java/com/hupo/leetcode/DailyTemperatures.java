package com.hupo.leetcode;

import java.util.Stack;

public class DailyTemperatures {

    /**
     * 计算气温
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {

        if (T == null || T.length == 0) {
            return new int[0];
        }

        int[] result = new int[T.length];

        Stack<Item> stack = new Stack<>();

        stack.push(new Item(T[0], 0));

        for (int i = 1; i <= T.length - 1; i++) {
            int temperature = T[i];

            while (!stack.isEmpty()) {
                Item topItem = stack.peek();
                if (topItem.temperature >= temperature) {
                    stack.push(new Item(temperature, i));
                    break;
                } else {
                    result[topItem.index] = i - topItem.index;
                    stack.pop();
                }
            }
            stack.push(new Item(temperature, i));
        }

        while (!stack.isEmpty()) {
            Item topItem = stack.pop();
            result[topItem.index] = 0;
        }

        return result;
    }


    public static class Item {
        public int temperature;
        public int index;

        public Item(int temperature, int index) {
            this.temperature = temperature;
            this.index = index;
        }
    }

}
