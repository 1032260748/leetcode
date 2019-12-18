package com.hupo.leetcode;


public class Multiply {

    public String multiply(String num1, String num2) {

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        String sum = "0";

        String zero = "";

        for (int i = num2.length() - 1; i >= 0; i--) {
            if (num2.charAt(i) == '0') {
                zero = zero + "0";
                continue;
            }

            sum = add(sum, multi(num1, num2.charAt(i) - '0', zero));
            zero = zero + "0";
        }

        return sum;
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();

        System.out.println(multiply.multiply("99", "21"));
    }

    public String multi(String num, int count, String zeroCount) {

        String sum = num;

        for (int i = 2; i <= count; i++) {

            sum = add(sum, num);
        }

        return sum + zeroCount;

    }


    public String add(String num1, String num2) {
        //"123"+"34";


        StringBuilder addResult = new StringBuilder();

        int flag = 0;

        int max = Math.max(num1.length(), num2.length());


        for (int i = 0; i <= max - 1; i++) {

            int temp1 = 0;

            int temp2 = 0;
            if (num1.length() - 1 - i >= 0) {
                temp1 = num1.charAt(num1.length() - 1 - i) - '0';
            }


            if (num2.length() - 1 - i >= 0) {
                temp2 = num2.charAt(num2.length() - 1 - i) - '0';
            }

            int result = (temp1 + temp2 + flag);

            if (result >= 10) {
                flag = 1;
                result = result - 10;
            } else {
                flag = 0;
            }

            addResult.insert(0, result);

        }

        if (flag == 1) {
            addResult.insert(0, 1);
        }


        return addResult.toString();
    }

}
