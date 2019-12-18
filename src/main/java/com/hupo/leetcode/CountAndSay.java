package com.hupo.leetcode;

public class CountAndSay {

    /**
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }

        String result = "1";
        int i = 2;

        while (i <= n) {
            result = getNext(result);
            i++;
        }

        return result;
    }

    private String getNext(String input) {
        StringBuilder builder = new StringBuilder();

        int count = 1;

        char pre = input.charAt(0);

        for (int i = 1; i <= input.length() - 1; i++) {
            if (input.charAt(i) != pre) {
                builder.append(Integer.toString(count));
                builder.append(Character.toString(pre));
                pre = input.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }

        builder.append(Integer.toString(count));
        builder.append(Character.toString(pre));
        return builder.toString();
    }

}
