package ru.job4j.interview.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicTacToeCheckerTest {
    @Test
    void notFinished() {
        assertEquals(-1, TicTacToeChecker.isSolved(new int[][] {
                {0, 0, 1},
                {0, 1, 2},
                {2, 1, 0}
        }), "[0, 0, 1]\n[0, 1, 2]\n[2, 1, 0]");
    }

    @Test
    void winnerX() {
        assertEquals(1, TicTacToeChecker.isSolved(new int[][] {
                {1, 1, 1},
                {0, 2, 2},
                {0, 0, 0}
        }), "[1, 1, 1]\n[0, 2, 2]\n[0, 0, 0]");
    }

    @Test
    void winnerO() {
        assertEquals(2, TicTacToeChecker.isSolved(new int[][] {
                {1, 1, 2},
                {0, 2, 0},
                {2, 1, 1}
        }), "[1, 1, 2]\n[0, 2, 0]\n[2, 1, 1]");
    }

    @Test
    void draw() {
        assertEquals(0, TicTacToeChecker.isSolved(new int[][] {
                {1, 2, 1},
                {1, 1, 2},
                {2, 1, 2}
        }), "[1, 2, 1]\n[1, 1, 2]\n[2, 1, 2]");
    }

    @Test
    void zeros() {
        assertEquals(-1, TicTacToeChecker.isSolved(new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        }));
    }
}