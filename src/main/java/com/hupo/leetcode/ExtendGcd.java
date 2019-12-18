package com.hupo.leetcode;

public class ExtendGcd {

    public class Result {

        public int x;
        public int y;

        public Result() {
        }

        public Result(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return this.x + " , " + this.y;
        }
    }

    public static void main(String[] args) {
        ExtendGcd extendGcd = new ExtendGcd();
        Result result = extendGcd.getXY(0, 1);
        System.out.println(result);
    }

    public Result getXY(int a, int b) {
        if (b == 0) {
            return new Result(1, 0);
        }

        Result preResult = getXY(b, a % b);

        Result result = new Result();
        result.x = preResult.y;
        result.y = preResult.x - (a / b) * preResult.y;

        return result;
    }


    public int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

}
