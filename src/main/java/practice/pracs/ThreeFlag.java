package practice.pracs;

public class ThreeFlag {

    public static void sortColors(int[] nums) {
        int n=nums.length;
        if(n==1){
            return;
        }
        int index=0;
        int left=0;
        int right=n-1;

        while(index<=right){ //TODO

            //left index of first one so far
            if(nums[index]==0){
                int temp=nums[index];
                nums[index]=nums[left];
                nums[left]=temp;
                index++;
                left++;
            }else if(nums[index]==2){
                //swap num[index] with num[right]

                int temp=nums[index];
                nums[index]=nums[right];
                nums[right]=temp;
                right--;
                //not incrementing left coz we could have swapped 2 with 2 here!

            }else{
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[]=new int[]{2,0,2,1,1,0};
        sortColors(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }
}
