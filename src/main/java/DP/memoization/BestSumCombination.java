package DP.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* n array length, m=target sum
* TC O((n^m)*m)
* SC O(m*m) m=height of the tree, size of smallestList could be m for any of the branch
*
* after memoization
* O(n*m  *m)
* SC O(m*m)
* */

public class BestSumCombination {

    private static List<Integer> bestSum(int targetSum, int nums[]){

        if(targetSum==0)return new ArrayList<>();
        if(targetSum<0)return null;

        List<Integer> smallestList=null;
       for(int num:nums){
           int diff=targetSum-num;
           List<Integer> currentList=bestSum(diff,nums);
           if(currentList!=null){
               currentList.add(num);
               if(smallestList==null || currentList.size()<smallestList.size()){
                   smallestList=currentList;
               }
           }
       }

        return smallestList;


    }


    private static List<Integer> bestSumMemo(int targetSum, int nums[],Map<Integer,List<Integer>> memo){
        if(memo.containsKey(targetSum)){
            return memo.get(targetSum);
        }
        if(targetSum==0)return new ArrayList<>();
        if(targetSum<0)return null;

        List<Integer> smallestList=null;
        for(int num:nums){
            int diff=targetSum-num;
            List<Integer> currentList=bestSumMemo(diff,nums,memo);
            if(currentList!=null){
                currentList=new ArrayList<>(currentList);
                currentList.add(num);
                if(smallestList==null || currentList.size()<smallestList.size()){
                    smallestList=currentList;
                }
            }
        }

        memo.put(targetSum, smallestList);
        return smallestList;


    }


    public static void main(String[] args) {
        System.out.println(bestSumMemo(100,new int[]{1,2,4,25,50},new HashMap<>()));
        System.out.println(bestSumMemo(7,new int[]{5,2,7},new HashMap<>()));
        System.out.println(bestSumMemo(7,new int[]{7,5,2},new HashMap<>()));
        System.out.println(bestSumMemo(7,new int[]{5,7,2},new HashMap<>()));



    }

}
