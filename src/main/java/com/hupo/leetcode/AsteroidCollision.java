package com.hupo.leetcode;


import java.util.Stack;

public class AsteroidCollision {

    public static void main(String[] args) {
        int[] nums = new int[]{8, -8};
        AsteroidCollision asteroidCollision = new AsteroidCollision();

        int[] result = asteroidCollision.asteroidCollision(nums);

        System.out.println(result);
    }


    public int[] asteroidCollision(int[] asteroids) {

        if (asteroids == null || asteroids.length == 0) {
            return new int[0];
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= asteroids.length - 1; i++) {
            int current = asteroids[i];
            handleCrash(stack, current);
        }

        int[] result = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    /**
     * 处理碰撞
     *
     * @param stack
     * @param current
     */
    public void handleCrash(Stack<Integer> stack, Integer current) {

        if (current > 0) {
            stack.push(current);
            return;
        }

        if (stack.isEmpty()) {
            stack.push(current);
            return;
        }

        Integer top = stack.peek();
        if (top < 0) {
            stack.push(current);
            return;
        }

        if (top == Math.abs(current)) {
            //发生碰撞，两个都消失
            stack.pop();
        } else if (Math.abs(top) > Math.abs(current)) {
            //发生碰撞，保留正值
            return;
        } else {
            //发生碰撞，并且保留 负值
            stack.pop();
            handleCrash(stack, current);
        }

    }


}
