package practice.pracs;

public class SumAllSubarrays {

    public static int sum(int a[]){

        //TC n^3
        int sum=0;
        int n=a.length;
        for(int i=0;i<n;i++){ //i gives me first elemnt

            for(int j=i;j<n;j++) { //control on number of elements

                for(int k=i;k<=j;k++){ //actally sums up between 1st elemt given by i & total number of elements decided by j
                    System.out.print(a[k]+" ");
                }
                System.out.println();
            }

        }

        return sum;
    }
    public static void main(String[] args) {
        int a[]=new int[]{1,2,3,4};
        System.out.println(sum(a));
    }

}
