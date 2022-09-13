package com.hupo.leetcode.str;

import java.util.Stack;


public class DecodeStringSolution {

    public static void main(String[] args) {
        DecodeStringSolution solution = new DecodeStringSolution();
        String decode = solution.decodeString("3[a]");
        System.out.println(decode.equals("aaa"));

        decode = solution.decodeString("3[a]2[b]");
        System.out.println(decode.equals("aaabb"));

        decode = solution.decodeString("3[a]2[b1[3[c]]]");
        System.out.println(decode.equals("aaabcbc"));

        decode = solution.decodeString("3[a]2[bc]");
        System.out.println(decode.equals("aaabcbc"));

        decode = solution.decodeString("3[a2[c]]");
        System.out.println(decode.equals("accaccacc"));

        decode = solution.decodeString("2[abc]3[cd]ef");
        System.out.println(decode.equals("abcabccdcdcdef"));

        decode = solution.decodeString("abc3[cd]xyz");
        System.out.println(decode.equals("abccdcdcdxyz"));
    }

    public String decodeString(String s) {
        StringBuffer resultBuffer = new StringBuffer();
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> txtStack = new Stack<>();
        Character prior = ' ';
        StringBuffer currentItem = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (isAbc(character)) {
                currentItem.append(character);
            } else if (Character.isDigit(character)) {
                if (isAbc(prior)) {
                    if (txtStack.isEmpty()) {
                        resultBuffer.append(currentItem);
                    } else {
                        txtStack.push(currentItem.toString());
                    }
                    currentItem = new StringBuffer();
                }
                currentItem.append(character);
            } else if (character == '[') {
                numberStack.push(Integer.parseInt(currentItem.toString()));
                currentItem = new StringBuffer();
                txtStack.push("[");
            } else if (character == ']') {
                txtStack.push(currentItem.toString());
                currentItem = new StringBuffer();
                StringBuilder temp = new StringBuilder();
                while (!"[".equals(txtStack.peek())) {
                    String topItem = txtStack.pop();
                    temp.insert(0, topItem);
                }
                txtStack.pop();
                int number = numberStack.pop();
                String timesTxt = times(temp.toString(), number);
                if (txtStack.isEmpty()) {
                    resultBuffer.append(timesTxt);
                } else {
                    txtStack.push(timesTxt);
                }
            }
            prior = character;
        }
        if (currentItem.length() > 0) {
            resultBuffer.append(currentItem);
        }
        return resultBuffer.toString();
    }

    private boolean isAbc(Character c) {
        return c >= 'a' && c <= 'z';
    }

    private String times(String temp, int times) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            stringBuilder.append(temp);
        }
        return stringBuilder.toString();
    }

}
