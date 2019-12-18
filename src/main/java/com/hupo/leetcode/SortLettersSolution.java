package com.hupo.leetcode;

public class SortLettersSolution {


    public static void main(String[] args) {
        char[] chars = "ABC".toCharArray();

        new SortLettersSolution().sortLetters(chars);
        System.out.println(new String(chars));

    }


    /*
     * @param chars: The letter array you should sort by Case
     * @return: nothing
     */
    public void sortLetters(char[] chars) {
        // write your code here

        if (chars == null || chars.length <= 1) {
            return;
        }

        int l = 0;
        int r = chars.length - 1;

        while (l < r) {

            if (isSmallLetter(chars[l])) {
                l++;
                continue;
            }

            swap(chars, l, r);
            r--;
        }
    }


    private boolean isBiggerLetter(char temp) {
        return temp >= 'A' && temp <= 'Z';
    }

    private boolean isSmallLetter(char temp) {
        return temp >= 'a' && temp <= 'z';
    }

    private void swap(char[] chars, int m, int n) {
        char temp = chars[m];
        chars[m] = chars[n];
        chars[n] = temp;
    }


}
