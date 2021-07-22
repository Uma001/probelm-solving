package practice.pracs;

public class AntiDiagonal {


    public static int[][] fillArray(){
        int n=4;
        int col_index=0;

        int a[][]=new int[n][n];
        for(int row=0;row<n;row++){
            col_index=n-1;
            for(int val=1;val<=row+1;val++){
                a[row][col_index--]=val;
            }
        }

        for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               System.out.print(a[i][j]+" ");
           }
            System.out.println();
        }

    return null;
    }

    public static void main(String[] args) {
        fillArray();
    }


}
