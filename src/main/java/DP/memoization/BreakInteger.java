package DP.memoization;

public class BreakInteger {

    /*
    * Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
    * Return the maximum product you can get.
    *
    * */
    public static int breakInt(int target, int ans){


        if(target<=1) {
            System.out.println("returing ans"+ans);
            return ans;
        }

        int maxAns=1;
        for(int i=1;i<target;i++){
            int newTarget=target-i;
            int currentAns=breakInt(newTarget, ans*i);
            if(maxAns==1 || currentAns>maxAns){
                maxAns=currentAns;
            }
        }

        return maxAns;

    }

    public static void main(String[] args) {
        System.out.println(breakInt(5,1));
    }
}
