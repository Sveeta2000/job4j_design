package ru.job4j.interview;

import java.util.Arrays;

public class TicTacToeChecker {
    public static int isSolved(int[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];
            }
            if (board[0][i] != 0 && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i];
            }
        }
        if (board[1][1] != 0 && ((board[0][0] == board[1][1] && board[1][1] == board[2][2])
                || (board[0][2] == board[1][1] && board[1][1] == board[2][0]))) {
            return board[1][1];
        }
        boolean isFinished = Arrays.stream(board).flatMapToInt(Arrays::stream).noneMatch(x -> x == 0);
        return isFinished ? 0 : -1;
    }
}
