package DP.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* n array length, m=target sum
* TC O(n^m)
* SC O(m*m) m=height of the tree, size of smallestList could be m for any of the branch
* */

public class HowSumCombination {

    static Map<Integer,List<Integer>> memo=new HashMap<>();

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


    private static List<Integer> howSumMemo(int targetSum, int nums[], Map<Integer,List<Integer>> memo){
        if(memo.containsKey(targetSum)){
            return memo.get(targetSum);
        }
        if(targetSum==0)return new ArrayList<>();
        if(targetSum<0)return null;

        for(int num:nums){
            int diff=targetSum-num;
            List<Integer> currentList= howSumMemo(diff,nums,memo);
            if(currentList!=null){
                currentList=new ArrayList<>(currentList);
                currentList.add(num);
                memo.put(targetSum,currentList);
                return currentList;
            }
        }

        return null;


    }


    public static void main(String[] args) {
        System.out.println(howSumMemo(100,new int[]{1,2,4,25,50},new HashMap<>()));
        System.out.println(howSumMemo(7,new int[]{5,2,7},new HashMap<>()));
        System.out.println(howSumMemo(7,new int[]{7,5,2},new HashMap<>()));
        System.out.println(howSumMemo(7,new int[]{5,7,2},new HashMap<>()));
    }

}
