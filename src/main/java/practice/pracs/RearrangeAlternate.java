package practice.pracs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeAlternate {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> triplets= new ArrayList<>();
        Arrays.sort(nums);
        int l,sum;

        for(int i=0;i<nums.length-2;i++){
            if(i==0 || (i>=1 && nums[i]!=nums[i-1])){
                sum=0-nums[i];
                l=i+1;
                int r=nums.length-1;
                while(l<r){
                    if(nums[l]+nums[r]==sum){
                        triplets.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        while(l<r && nums[l]==nums[l+1]){
                            l++;
                        }
                        while(l<r && nums[r]==nums[r-1]){
                            r--;
                        }
                        l++;
                        r--;
                    }else if(sum>nums[l]+nums[r]){
                        l++;
                    }else{
                        r--;
                    }

                }

            }


        }
        return triplets;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}).toString());
    }
}
