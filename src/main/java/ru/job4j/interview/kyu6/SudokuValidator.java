package ru.job4j.interview.kyu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SudokuValidator {

    private static final int[] NUMBERS = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static boolean validate(int[][] board) {
        boolean rowCheck = false;
        boolean columnCheck = false;
        boolean blockCheck = true;
        boolean hasZeros = Arrays.stream(board).flatMapToInt(Arrays::stream).anyMatch(x -> x == 0);
        if (!hasZeros) {
            for (int i = 0; i < 9; i++) {
                if (!hasAllNumbers(board[i])) {
                    rowCheck = false;
                    break;
                }
                rowCheck = true;
            }
        }
        if (rowCheck) {
            for (int c = 0; c < 9; c++) {
                int finalC = c;
                int[] column = IntStream.range(0, board.length).map(i -> board[i][finalC]).toArray();
                if (!hasAllNumbers(column)) {
                    columnCheck = false;
                    break;
                }
                columnCheck = true;
            }
        }
        if (columnCheck) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 9; j++) {
                    List<Integer> block = makeBlock(i * 3, i * 3 + 2, j, j + 2, board);
                    if (!hasAllNumbers(block.stream().mapToInt(Integer::intValue).toArray())) {
                        blockCheck = false;
                        break;
                    }
                    j = j + 2;
                }
            }
        }
        return !hasZeros && rowCheck && columnCheck && blockCheck;
    }

    /**
     * checks if the array contains all numbers from 1 to 9, without duplicates
     *
     * @param array is the array we want to check
     * @return true if the array contains all numbers from 1 to 9, without duplicates, or false otherwise
     */
    private static boolean hasAllNumbers(int[] array) {
        return Arrays.equals(NUMBERS, Arrays.stream(array).sorted().toArray());
    }

    private static List<Integer> makeBlock(int fromRow, int toRow, int fromColumn, int toColumn, int[][] array) {
        List<Integer> block = new ArrayList<>();
        for (int i = fromRow; i <= toRow; i++) {
            for (int j = fromColumn; j <= toColumn; j++) {
                block.add(array[i][j]);
            }
        }
        return block;
    }
}