package com.hupo.leetcode;


/**
 * 测量水
 */
public class MeasureWater {

    public boolean canMeasureWater(int x, int y, int z) {

        int factor = maxFactor(x, y);

        if (z > x + y) {
            return false;
        }

        if (factor == 0) {
            if (z == 0) {
                return true;
            }
            return false;
        }

        return z % factor == 0;

    }

    public static void main(String[] args) {
        MeasureWater water = new MeasureWater();

        System.out.println(water.canMeasureWater(3, 5, 6));
        System.out.println(water.canMeasureWater(3, 5, 0));
        System.out.println(water.canMeasureWater(3, 5, 9));
        System.out.println(water.canMeasureWater(2, 6, 5));


    }


    public int maxFactor(int x, int y) {
        int min = Math.min(x, y);
        int max = Math.max(x, y);

        if (min == 0) {
            return max;
        }

        if (min <= 1) {
            return min;
        }

        if (max % min == 0) {
            return min;
        }

        return maxFactor(min, max % min);
    }


}
