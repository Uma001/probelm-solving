package practice.pracs.twoDArray;

public class TwoDPrefixSum {

    private static void calculatePrefixSum(int[][] arr){

        int rows=arr.length;
        int columns=arr[0].length;
        int sum=0;
        for(int i=0;i<rows;i++){
            sum=0;
            for(int j=0;j<columns;j++){
                sum+=arr[i][j];
                arr[i][j]=sum;
            }
        }


        for(int i=0;i<columns;i++){
            sum=0;
            for(int j=0;j<rows;j++){
                sum+=arr[j][i];
                arr[j][i]=sum;
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        int[][] arr= {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        calculatePrefixSum(arr);


    }
}
