package com.hupo.leetcode.sequece;


import com.hupo.leetcode.ExtendGcd;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLIS {


    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        LengthOfLIS length = new LengthOfLIS();
        int maxLength = length.lengthOfLIS(arr);

        System.out.println(maxLength);

        String str = length.longestPalindrome("a");
        System.out.println(str);

        int[][] array = new int[3][3];
        array[0] = new int[]{1, 1, -1};
        array[1] = new int[]{1, -1, 1};
        array[2] = new int[]{-1, 1, 1};

        System.out.println(length.numberOf2sInRange(559366752));

    }

    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }


        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    result[i] = Math.max(result[i], 1 + result[j]);
                }
            }
        }

        int max = result[0];

        for (int i = 1; i <= result.length - 1; i++) {
            max = Math.max(max, result[i]);
        }
        return max;
    }


    public String longestPalindrome(String s) {

        if (s == null) {
            return null;
        }
        if (s.length() <= 1) {
            return s;
        }

        int[][] result = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i][i] = 1;
        }

        for (int gap = 1; gap <= s.length() - 1; gap++) {
            for (int i = 0; i + gap <= s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + gap)) {
                    if (i + 1 <= i + gap - 1) {
                        if (result[i + 1][i + gap - 1] > 0) {
                            result[i][i + gap] = 2 + result[i + 1][i + gap - 1];
                        } else {
                            result[i][i + gap] = 0;
                        }
                    } else {
                        result[i][i + gap] = 2;
                    }
                }
            }
        }

        String strStr = "";
        for (int i = 0; i <= s.length() - 1; i++) {
            for (int j = 0; j <= s.length() - 1; j++) {
                if (result[i][j] > strStr.length()) {
                    strStr = s.substring(i, j + 1);
                }
            }
        }
        return strStr;
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] result = new int[m][n];

        result[m - 1][n - 1] = grid[m - 1][n - 1];

        for (int i = m - 2; i >= 0; i--) {
            result[i][n - 1] = result[i + 1][n - 1] + grid[i][n - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            result[m - 1][i] = result[m - 1][i + 1] + grid[m - 1][i];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                result[i][j] = grid[i][j] + Math.min(result[i + 1][j], result[i][j + 1]);
            }
        }

        return result[0][0];
    }


    public int cherryPickup(int[][] grid) {
        int[][] result = cherryPickupInner(grid);
        if (result.length == 0) {
            return 0;
        }
        if (result[0][0] <= 0) {
            return 0;
        }

        int sum = result[0][0];
        int temp = sum;

        int i = 0;
        int j = 0;
        while (i <= grid.length - 1 && j <= grid[0].length - 1 & temp > 0) {
            if (grid[i][j] >= 0) {
                temp = temp - grid[i][j];
                grid[i][j] = 0;
                if (i + 1 <= grid.length - 1 && result[i + 1][j] == temp) {
                    i++;
                    continue;
                }
                if (j + 1 <= grid[0].length - 1 && result[i][j + 1] == temp) {
                    j++;
                    continue;
                }
            }
        }

        return sum + cherryPickupInner(grid)[0][0];
    }

    /**
     * -1没有路径
     *
     * @param grid
     * @return
     */
    public int[][] cherryPickupInner(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new int[0][0];
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] result = new int[m][n];

        if (grid[m - 1][n - 1] == -1) {
            result[m - 1][n - 1] = -1;
        } else {
            result[m - 1][n - 1] = grid[m - 1][n - 1];
        }

        for (int i = m - 2; i >= 0; i--) {
            if (result[i + 1][n - 1] < 0 || grid[i][n - 1] < 0) {
                result[i][n - 1] = -1;
            } else {
                result[i][n - 1] = result[i + 1][n - 1] + grid[i][n - 1];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (result[m - 1][i + 1] < 0 || result[m - 1][i] < 0) {
                result[m - 1][i] = -1;
            } else {
                result[m - 1][i] = result[m - 1][i + 1] + grid[m - 1][i];
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (grid[i][j] < 0) {
                    result[i][j] = grid[i][j];
                    continue;
                }
                if (result[i + 1][j] >= 0 && result[i][j + 1] >= 0) {
                    result[i][j] = grid[i][j] + Math.max(result[i + 1][j], result[i][j + 1]);
                } else if (result[i + 1][j] < 0 && result[i][j + 1] < 0) {
                    result[i][j] = -1;
                } else if (result[i + 1][j] >= 0) {
                    result[i][j] = grid[i][j] + result[i + 1][j];
                } else {
                    result[i][j] = grid[i][j] + result[i][j + 1];
                }
            }
        }

        return result;
    }


    public int numberOf2sInRange(int n) {

        if (n <= 1) {
            return 0;
        }
        int result = 1;

        for (int i = 3; i <= n; i++) {
            result = result + get2Nums(i);
        }
        return result;

    }

    public int numberOf2sInRange2(int n) {

        if (n <= 1) {
            return 0;
        }
        List<Integer> array = new ArrayList<>();
        int temp = n;
        while (temp != 0) {
            array.add(temp % 10);
            temp = temp / 10;
        }

        int length = array.size();

        if (length == 1) {
            return 1;
        }

        int sum = 1;
        for (int i = 1; i <= length - 2; i++) {
            //todo
            sum=0;
        }

        return sum;
    }

    private int get2Nums(int i) {
        int temp = i;
        int count = 0;
        while (temp > 0) {
            if (temp % 10 == 2) {
                count++;
            }
            temp = temp / 10;
        }
        return count;
    }


}
