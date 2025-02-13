package problems;

public class Problem36ValidSudoku {

    private boolean isDigit(char c) {
        return c >= '1' && c <= '9';
    }

    private boolean validateCountArray(int[] countArr) {
        for (int count : countArr) {
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidRow(char[] row) {
        int[] count = new int[10];
        for (char c : row) {
            if (isDigit(c)) {
                count[c - '0']++;
            }
        }
        return validateCountArray(count);
    }

    private boolean isValidColumn(char[][] board, int colIndex) {
        int[] count = new int[10];
        for (int i = 0; i < board.length; i++) {
            if (isDigit(board[i][colIndex])) {
                count[board[i][colIndex] - '0']++;
            }
        }
        return validateCountArray(count);
    }

    private boolean areValidBlocks(char[][] board, int startRow, int endRow, int startCol, int endCol) {
        int[] count = new int[10];
        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (isDigit(board[i][j])) {
                    count[board[i][j] - '0']++;
                }
            }
        }
        return validateCountArray(count);
    }

    public boolean isValidSudoku(char[][] board) {
        for (char[] row : board) {
            if (!isValidRow(row)) {
                return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (!isValidColumn(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < board.length - 2; i += 3) {
            for (int j = 0; j < board.length - 2; j += 3) {
                if (!areValidBlocks(board, i, i + 3, j, j + 3)) {
                    return false;
                }
            }
        }
        return true;
    }
}
