package com.hupo.leetcode;


public class CanCompleteCircuit {


    public int canCompleteCircuit(int[] gas, int[] cost) {

        if (gas == null || gas.length == 0) {
            return -1;
        }


        for (int i = 0; i <= gas.length - 1; i++) {
            int currentPos = 0;
            int count = 0;
            int currentIndex = i;

            while (count < gas.length) {
                currentPos = currentPos + gas[currentIndex];
                if (currentPos >= cost[currentIndex]) {
                    currentPos = currentPos - cost[currentIndex];
                    currentIndex = (currentIndex + 1) % gas.length;
                    count++;
                } else {
                    break;
                }
            }
            if (count == gas.length) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{4};
        int[] cost = new int[]{2};

        CanCompleteCircuit canCompleteCircuit = new CanCompleteCircuit();
        int index = canCompleteCircuit.canCompleteCircuit(gas, cost);

        System.out.println(index);
    }

}
