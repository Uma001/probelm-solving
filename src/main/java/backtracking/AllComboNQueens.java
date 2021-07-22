package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AllComboNQueens {

    private static Set<Integer> col = new HashSet<>();
    private static Set<Integer> diag = new HashSet<>();
    private static Set<Integer> antiDiag = new HashSet<>();

    private void putNQueens(int[][] board, int row, int N, ArrayList<ArrayList<String>> result){

        if(row>=N){
            ArrayList<String> list=new ArrayList<>();

            for(int i=0;i<N;i++){
                String current=new String();
                for(int j=0;j<N;j++){
                    if(board[i][j]==1){
                        current+='Q';
                    }else {
                        current+='-';
                    }
                }
                list.add(current);
            }

            result.add(list);
            return ;
        }


        ArrayList<ArrayList<String>> lists=null;
        for(int col=0;col<N;col++){

//            if(isSafe(row,col)){
//                board[row][col]=1;
////                if(putNQueens())
//
////            }


        }
//        return lists;

    }

    private static boolean isSafe(int row,int col) {

//        return !(column.contains(col) || diag.contains(row-col) || antiDiag.contains(row+col));
        return false;
    }


    public static void main(String[] args) {

    }
}
