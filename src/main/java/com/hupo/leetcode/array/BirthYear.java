package com.hupo.leetcode.array;

/**
 * 给定 N 个人的出生年份和死亡年份，第 i 个人的出生年份为 birth[i]，死亡年份为 death[i]，实现一个方法以计算生存人数最多的年份。
 * <p>
 * 你可以假设所有人都出生于 1900 年至 2000 年（含 1900 和 2000 ）之间。如果一个人在某一年的任意时期处于生存状态，那么他应该被纳入那一年的统计中。例如，生于 1908 年、死于 1909 年的人应当被列入
 * 1908 年和 1909 年的计数。
 * <p>
 * 如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
 * 查分数组
 */
public class BirthYear {

    public static void main(String[] args) {
        int[] year = new BirthYear().prevPermOpt1(new int[] { 9, 7, 7 });
        System.out.println(year);
    }

    public int[] prevPermOpt1(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int currentIndex = i;
            int findIndex = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] == arr[currentIndex]) {
                    currentIndex = j;
                } else if (arr[j] > arr[currentIndex]) {
                    findIndex = j;
                    break;
                }
            }
            if (findIndex >= 0) {
                int temp = arr[currentIndex];
                arr[currentIndex] = arr[findIndex];
                arr[findIndex] = temp;
                break;
            }
        }
        return arr;
    }

    public int maxAliveYear(int[] birth, int[] death) {
        int[] years = new int[102];
        for (int i = 0; i <= birth.length - 1; i++) {
            int birthYear = birth[i];
            int deathYear = death[i];
            int start = birthYear - 1900;
            int end = deathYear - 1900;
            years[start] += 1;
            years[end + 1] -= 1;
        }
        int sum = 0;
        int max = 0;
        int index = 0;
        for (int i = 0; i <= years.length - 2; i++) {
            sum = sum + years[i];
            if (sum > max) {
                max = sum;
                index = i;
            }
        }
        return index + 1900;
    }
}
