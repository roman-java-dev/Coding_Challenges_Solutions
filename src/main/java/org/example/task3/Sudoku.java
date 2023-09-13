package org.example.task3;

public class Sudoku {
    private final int[][] board;
    private final int boardLength;
    private final int squareLength;

    public Sudoku(int[][] sudokuData) {
        board = sudokuData;
        boardLength = sudokuData.length;
        squareLength = (int) Math.sqrt(sudokuData.length);
    }

    public boolean isValid() {
        for (int i = 0; i < boardLength; i++) {
            boolean[] rowChecked = new boolean[boardLength + 1];
            boolean[] columnChecked = new boolean[boardLength + 1];
            boolean[] squareChecked = new boolean[boardLength + 1];

            for (int j = 0; j < boardLength; j++) {
                int boardValue = board[i][j];
                if (boardValue == 0 || boardValue > boardLength)
                    return false;

                if (rowChecked[boardValue])
                    return false;
                rowChecked[boardValue] = true;

                boardValue = board[j][i];
                if (columnChecked[boardValue])
                    return false;
                columnChecked[boardValue] = true;

                int squareRow = squareLength * (i / squareLength);
                int squareColumn = squareLength * (i % squareLength);

                boardValue = board[(j % squareLength) + squareRow][(j / squareLength) + squareColumn];
                if (squareChecked[boardValue])
                    return false;
                squareChecked[boardValue] = true;
            }
        }

        return true;
    }
}