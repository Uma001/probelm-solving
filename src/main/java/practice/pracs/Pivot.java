package practice.pracs;

public class Pivot {

    public static int pivotIndex(int[] nums) {

        int size=nums.length;
        int left[]=new int[size+1];
        int right[]=new int[size+1];
        left[0]=0;
        for(int i=1;i<size;i++){
            left[i]=left[i-1]+nums[i-1];
        }
        right[size]=0;
        for(int i=size-1;i>=0;i--){
            right[i]=right[i+1]+nums[i];
        }

        for(int i=0;i<size+1;i++){
            System.out.print(left[i]+" ");
        }
        System.out.println();
        for(int i=0;i<size+1;i++){
            System.out.print(right[i]+" ");
        }

        for(int i=0;i<size;i++){
            System.out.print(left[i]+" ");
            System.out.print(right[i+1]+" ");
            System.out.println();

            if(left[i]==right[i+1]){
                return i;
            }
        }

        return -1;

    }
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{-1,-1,-1,-1,-1,0}));
    }
}
