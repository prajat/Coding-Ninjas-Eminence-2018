import java.util.*;
/**
 * nqueen
 */
public class nqueen {

    public static void main(String[] args) {

        placeNQueens(8);
        
    }
    
    public static void placeNQueens(int n) {

        int[][] board = new int[n][n];
        
        
        placeNqueenhelper( board, 0);
    }

    public static void placeNqueenhelper(int[][] board, int row) {
        if (row >=board.length) {
            printboard(board);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (ifpossible(row, col,board)) {
                board[row][col] = 1;
                placeNqueenhelper(board, row + 1);
                board[row][col] = 0;
            }

        }
        

    }

    public static boolean ifpossible(int row, int col, int[][] board) {
       
        for (int i = row-1; i >= 0; i--) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        for (int i = row-1 , j = col-1 ; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }

        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            
            if(board[i][j]==1){
                return false;
            }
        }
        return true;
        
    }

    public static void printboard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
        }
        System.out.println();

    }
    
    
}