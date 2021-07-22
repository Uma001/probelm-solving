package practice.pracs;

public class MaxSumSubarray {
    //Maximum sum subarray with fixed size 'k'

    public static int maxSumOfKSize(int[] arr, int k){

        int runningSum=0;
        int maxSum=Integer.MIN_VALUE;
        int n=arr.length;
        for(int i=0;i<n-k;i++){
            runningSum+=arr[i];
            if(i>=k-1){ //why '=' k-1 ? "till k-1 u got K elements"
                maxSum=Math.max(runningSum,maxSum);
                runningSum-=arr[i-(k-1)];
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSumOfKSize(new int[]{1,2,3,5,9,10,2,4,24,9,20,1,1,1},3));
    }
}
