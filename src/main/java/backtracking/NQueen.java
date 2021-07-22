package backtracking;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;


/*
* given a board of n*n return if N queens could be placed on it
*
* */

public class NQueen {

    //put queen at correct position in 1st row
    //check if you can put the next queen in next row

    static int[][]  board ;
    static Set<Integer> diag;
    static Set<Integer> antiDiag;
    static Set<Integer> column;

    private static boolean canPutNQueens(int N, int row){
        if(row>=board.length){
            return true;
        }

        for(int col=0;col<board[0].length;col++){

            if(isSafe(row,col)){
                board[row][col]=1;
                diag.add(row-col);
                antiDiag.add(row+col);
                column.add(col);

                if(canPutNQueens(N,row+1)){
                    return true;
                }
                board[row][col]=0;
                diag.remove(row-col);
                antiDiag.remove(row+col);
                column.remove(col);
            }

        }

        return false;

    }

    private static boolean isSafe(int row,int col) {

        return !(column.contains(col) || diag.contains(row-col) || antiDiag.contains(row+col));

    }

    public static void main(String[] args) {

        board = new int[4][4];
        diag=new HashSet<>();
        antiDiag=new HashSet<>();
        column=new HashSet<>();
        System.out.println(canPutNQueens(3,0));
    }
}
