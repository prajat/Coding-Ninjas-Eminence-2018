
public class Solution {

    public static boolean sudokuSolver(int board[][]) {

        int row = -1;
        int col = -1;
        boolean isempty = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    isempty = true;
                    row = i;
                    col = j;
                    break;
                }
            }
            if (isempty) {
                break;
            }
        }
        if (!isempty) {
            return true;
        }

        for (int num = 1; num <= 9; num++) {
            if (canplacenum(board, row, col, num)) {
                board[row][col] = num;
                if (sudokuSolver(board)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }

        }
        return false;

    }

    public static boolean canplacenum(int[][] board, int row, int col, int num) {
        if (!isrowsafe(board, row, num)) {
            return false;
        }
        if (!iscolsafe(board, col, num)) {
            return false;
        }
        if (!isboxsafe(board, row, col, num)) {
            return false;
        }
        return true;

    }

    public static boolean isrowsafe(int[][] board, int row, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num)
                return false;
        }
        return true;

    }

    public static boolean iscolsafe(int[][] board, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num)
                return false;
        }
        return true;

    }

    public static boolean isboxsafe(int[][] board, int row, int col, int num) {
        int rowstart = row - row % 3;
        int colstart = col - col % 3;
        for (int i = rowstart; i < rowstart + 3; i++) {
            for (int j = colstart; j < colstart + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;

    }

}
