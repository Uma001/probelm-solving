package practice.pracs;
//TODO

public class RotateArray {

    public static int[][] solve(int[] A, int[] B) {
        int n=A.length;
        int m=B.length;
        int arr[][]=new int[m][];

        for(int i=0;i<m;i++){
            int a[]=new int[n];
            for(int j=0;j<n;j++){
                a[j]=A[j];
            }
            arr[i]=a;
        }
        for(int i=0;i<m;i++){
            int d=B[i];
            reverse(arr[i],0,d);
            reverse(arr[i],d+1,n-1);
            reverse(arr[i],0,n-1);
        }


//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
        return arr;

    }

    public static void reverse(int A[], int l, int r){
        int temp;
        while(l<r){
            temp=A[l];
            A[l]=A[r];
            A[r]=temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{6, 31, 33, 13, 82, 66, 9, 12, 69, 21, 17, 2, 50, 69, 90, 71, 31, 1, 13, 70, 94, 46, 89, 13, 55, 54, 67, 97, 28, 27, 62, 34, 41, 18, 15, 35, 13, 84, 93, 27, 89, 23, 6, 56, 94, 40, 54, 95, 47},new int[]{88, 85, 98, 36, 66, 40, 30, 26, 51, 77, 62, 60, 92, 64, 53, 86, 24, 53, 85, 49, 57, 29, 32, 60, 75, 82, 17, 23, 67, 51, 23, 11, 70, 59 }));
    }
}
