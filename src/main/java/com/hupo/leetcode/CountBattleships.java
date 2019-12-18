package com.hupo.leetcode;


public class CountBattleships {

    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i <= board.length - 1; i++) {
            for (int j = 0; j <= board[0].length - 1; j++) {
                if (board[i][j] == 'X') {

                    if (i - 1 >= 0 && board[i - 1][j] == 'X') {
                        continue;
                    }
                    if (j - 1 >= 0 && board[i][j - 1] == 'X') {
                        continue;
                    }
                    result++;

                }
            }
        }

        return result;
    }
}
