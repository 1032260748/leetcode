package com.hupo.leetcode.str;

public class ZConvert {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuffer[] arrays = new StringBuffer[numRows];
        for (int i = 0; i <= numRows - 1; i++) {
            arrays[i] = new StringBuffer();
        }
        int currentIndex = 0;
        int flag = 1;
        for (int i = 0; i <= s.length() - 1; i++) {
            arrays[currentIndex].append(s.charAt(i));
            if (currentIndex == 0) {
                flag = 1;
            } else if (currentIndex == numRows - 1) {
                flag = 0;
            }
            if (flag == 1) {
                currentIndex++;
            } else {
                currentIndex--;
            }
        }
        StringBuffer resultBuffer = new StringBuffer();
        for (int i = 0; i <= numRows - 1; i++) {
            resultBuffer.append(arrays[i].toString());
        }
        return resultBuffer.toString();
    }

    public static void main(String[] args) {
        ZConvert convert = new ZConvert();
        boolean result = "A".equals(convert.convert("ABC", 2));
        System.out.println(result);
        result = "PINALSIGYAHRPI".equals(convert.convert("PAYPALISHIRING", 4));
        System.out.println(result);
    }

}
