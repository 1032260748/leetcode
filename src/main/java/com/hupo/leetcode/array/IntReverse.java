package com.hupo.leetcode.array;

public class IntReverse {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int flag = x >= 0 ? 1 : -1;
        StringBuffer buffer = new StringBuffer();
        int temp = x;
        boolean hasNonZero = false;
        while (temp != 0) {
            int current = temp % 10;
            if (hasNonZero) {
                buffer.append(current * flag);
            } else {
                if (current != 0) {
                    buffer.append(current * flag);
                    hasNonZero = true;
                }
            }
            temp = temp / 10;
        }

        String maxStr = Integer.toString(Integer.MAX_VALUE);
        if (flag == 1 && buffer.length() >= maxStr.length()) {
            if (buffer.toString().compareTo(maxStr) > 0) {
                return 0;
            }
        } else if (flag == -1) {
            String minStr = Integer.toString(Integer.MIN_VALUE);
            String numberStr = "-" + buffer;
            if (numberStr.length() >= minStr.length() && numberStr.compareTo(minStr) > 0) {
                return 0;
            }
        }
        return Integer.parseInt(buffer.toString()) * flag;
    }

    public static void main(String[] args) {
        IntReverse intReverse = new IntReverse();
        int result = intReverse.reverse(-2147483648);
        System.out.println(result);
        result = intReverse.reverse(-34500);
        System.out.println(result);
    }

}
