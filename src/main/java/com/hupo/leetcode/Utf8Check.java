package com.hupo.leetcode;

public class Utf8Check {

    /**
     * 是否是有效的UTF8编码
     *
     * @param data
     * @return
     */
    public boolean validUtf8(int[] data) {
        int index = 0;
        while (index <= data.length - 1) {
            int temp = checkFirst((byte) data[index]);
            if (temp > 4 || temp == 1) {
                return false;
            }

            if (temp == 0) {
                index = index + 1;
                continue;
            }

            if (index + temp - 1 > data.length - 1) {
                return false;
            }

            for (int j = 1; j <= temp - 1; j++) {
                if (!checkInnerByte((byte) data[index + j])) {
                    return false;
                }
            }
            index = index + temp;
        }
        return true;
    }

    public int checkFirst(byte data) {
        int i = 0;
        while (((data >> (7 - i) & 1) == 1) && i <= 5) {
            i++;
        }
        return i;
    }

    public boolean checkInnerByte(byte data) {
        if (((data >> 7 & 1) == 1) && ((data >> 6 & 1) == 0)) {
            return true;
        }
        return false;
    }


}
