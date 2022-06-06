package com.hupo.leetcode.str;

public class AddString {

    public static void main(String[] args) {
        AddString addString = new AddString();
        System.out.println(addString.addStrings("11", "123"));
    }

    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        StringBuilder buffer = new StringBuilder();
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int flag = 0;
        while (m >= 0 || n >= 0) {

            int number1 = 0;
            int number2 = 0;
            if (m >= 0) {
                number1 = num1.charAt(m) - '0';
            }
            if (n >= 0) {
                number2 = num2.charAt(n) - '0';
            }

            int current = (number1 + number2 + flag) % 10;
            buffer.insert(0, current);

            flag = (number1 + number2 + flag) / 10;

            m--;
            n--;
        }
        if (flag > 0) {
            buffer.insert(0, flag);
        }
        return buffer.toString();
    }

}
