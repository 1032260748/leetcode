package com.hupo.leetcode.str;

import java.util.ArrayList;
import java.util.List;


public class IntToRomanSolution {

    public static class RomanMapping {
        public Integer number;
        public String str;

        public RomanMapping() {
        }

        public RomanMapping(int number, String str) {
            this.number = number;
            this.str = str;
        }
    }

    public String intToRoman(int num) {
        List<RomanMapping> numbers = new ArrayList<>();
        numbers.add(new RomanMapping(1000, "M"));
        numbers.add(new RomanMapping(900, "CM"));
        numbers.add(new RomanMapping(500, "D"));
        numbers.add(new RomanMapping(400, "CD"));
        numbers.add(new RomanMapping(100, "C"));
        numbers.add(new RomanMapping(90, "XC"));
        numbers.add(new RomanMapping(50, "L"));
        numbers.add(new RomanMapping(40, "XL"));
        numbers.add(new RomanMapping(10, "X"));
        numbers.add(new RomanMapping(9, "IX"));
        numbers.add(new RomanMapping(5, "V"));
        numbers.add(new RomanMapping(4, "IV"));
        numbers.add(new RomanMapping(1, "I"));
        StringBuffer resultBuffer = new StringBuffer();

        for (int i = 0; i <= numbers.size() - 1; i++) {
            int count = num / numbers.get(i).number;
            if (count > 0) {
                resultBuffer.append(countStr(count, numbers.get(i).str));
                num = num % numbers.get(i).number;
            }
        }
        return resultBuffer.toString();
    }

    private String countStr(int count, String str) {
        if (count == 0 || str == null || str.length() == 0) {
            return "";
        }
        StringBuffer result = new StringBuffer();
        for (int i = 1; i <= count; i++) {
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        IntToRomanSolution solution = new IntToRomanSolution();
        System.out.println(solution.intToRoman(3));
        System.out.println(solution.intToRoman(4));
        System.out.println(solution.intToRoman(9));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(1994));
    }
}
