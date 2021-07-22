package practice.pracs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AP {

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<l.length;i++){
            int left=l[i];
            int arr[]=new int[r[i]-left+1];

            if(arr.length==1){
                ans.add(true);
                return ans;
            }
            for(int j=0;j<arr.length;j++){
                arr[j]=nums[left++];
                System.out.print(arr[j]+" ");

            }


            Arrays.sort(arr);

            int diff=arr[1]-arr[0];
            boolean diffConstant=true;
            for(int k=1;k<arr.length-1;k++){
                System.out.println();
                System.out.println(arr[k+1]+" "+arr[k]+" equals? ");
                if(diff!=arr[k+1]-arr[k]){

                    diffConstant=false;
                    ans.add(false);
                    break;
                }
            }

            if(diffConstant){
                ans.add(diffConstant);
            }
            System.out.println();
            System.out.println("****");
        }
        return ans;

    }


    public static void main(String[] args) {
        System.out.println(checkArithmeticSubarrays(new int[]{4,6,5,9,3,7},new int[]{0,0,2},new int[]{2,3,5}));
    }
}
