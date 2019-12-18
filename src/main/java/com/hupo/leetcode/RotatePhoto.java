package com.hupo.leetcode;

public class RotatePhoto {

    public static void main(String[] args) {
        int[][] array = new int[4][4];
        array[0] = new int[]{1, 2, 3, 4};
        array[1] = new int[]{5, 6, 7, 8};
        array[2] = new int[]{9, 10, 11, 12};
        array[3] = new int[]{12, 13, 14, 15};

        RotatePhoto rotatePhoto = new RotatePhoto();
        rotatePhoto.rotate(array);
        System.out.println(array);
    }


    /**
     * 翻转
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {

        int temp = matrix.length;
        if (matrix.length % 2 == 1) {
            temp = temp + 1;
        }

        for (int i = 1; i <= (temp) / 2; i++) {
            for (int j = i; j <= (temp - 2 * i) / 2; j++) {
                rotate(matrix, i - 1, j - 1);
            }
        }
    }

    public void rotate(int[][] matrix, int startI, int starJ) {
        int hole = matrix[startI][starJ];
        int targetI = starJ;
        int targetJ = matrix.length - 1 - startI;

        while (targetI != startI || targetJ != starJ) {
            int temp = matrix[targetI][targetJ];
            matrix[targetI][targetJ] = hole;
            hole = temp;

            int tempI = targetI;
            targetI = targetJ;
            targetJ = matrix.length - 1 - tempI;
        }
        matrix[targetI][targetJ] = hole;
    }

}
