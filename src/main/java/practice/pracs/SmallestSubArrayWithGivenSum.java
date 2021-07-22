package practice.pracs;

public class SmallestSubArrayWithGivenSum {

    public static int smallestSubArray(int arr[], int k){

//        int length=0;
        int minLength=Integer.MAX_VALUE;
        int sum=0;
        int left=0;
        for(int index=0;index<arr.length;index++){
//            length++;
            sum+=arr[index];
            while(sum>=k){
                minLength=Math.min(minLength,index-left+1); //based on window size
//                if(length<minLength){
//                    minLength=length;
//                }
                sum-=arr[left++];
//                length--;
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        System.out.println(smallestSubArray(new int[]{1,2,3,4,5,6,7,6,1},7));
        System.out.println(smallestSubArray(new int[]{7},7));
    }
}
