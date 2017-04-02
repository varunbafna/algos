import java.util.Scanner;
import java.util.Arrays;

public class NQueenProblem { 
    private static String placeQueenOnBoard(int Qi, int[] board) {
        //base case
        if (Qi == board.length) {
            return Arrays.toString(board);
        } 
        else if (board.length == 2 || board.length == 3) {
            return "No possible board.";
        }
        else {
        //try to put the ith Queen (Qi) in all of the columns
            for (int column = 0; column < board.length; column++) {
                if (isSafePlace(column, Qi, board)) {
                    board[Qi] = column;
                    //then place remaining queens.
                    placeQueenOnBoard(Qi + 1, board);
                   /**
                   * backtracking  is not required in this as we only look previously
                   * placed queens in isSafePlace method and it doesnot care what values
                   * are available in next positions.*
                   */
                    board[Qi] = -1;
                }
            }
        }
      return "";
    }
 
    //check if the column is safe place to put Qi (ith Queen)
    private static boolean isSafePlace(int column, int Qi, int[] board) {
        //check for all previously placed queens
        for (int i = 0; i < Qi; i++) {
            if (board[i] == column) { // the ith Queen(previous) is in same column
                return false;
            }
     
            //the ith Queen is in diagonal
            //(r1, c1) - (r2, c1). if |r1-r2| == |c1-c2| then they are in diagonal
            if (Math.abs(board[i] - column) == Math.abs(i - Qi)) {
                return false;
            }
        }
        return true;
    }
 
    public static void main(String[] args) {
        int n = 7; // Can be changed from 1 to 8
        int[] board = new int[n]; 
        placeQueenOnBoard(0, board);
    }
}     

