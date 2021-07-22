package backtracking;

import sun.text.normalizer.Trie;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class KDigNumsWithSumS {
    private static ArrayList<String> ans;
    //Print all n-digit numbers whose sum of digits equals to given sum
    private static void findNDigitNums(int n, int sum, String currStr, int curNum){
        if(curNum>sum){
            return;
        }

        if(currStr.length()==n){
            if(curNum==sum){
//                System.out.println(currStr);
                ans.add(currStr);
            }
            return;
        }

        for(int i=0;i<=9;i++){
            if(i!=0 || currStr.length()!=0){
                findNDigitNums(n,sum,currStr+i,curNum+i);
            }
        }
    }

    public static void main(String[] args) {

        int len=2;
        int sum=2;
        getSumEqualsTargetList(len,sum);

//        for(String s: ans){
//            System.out.print(s+" ");
//        }

    }

    private static void getSumEqualsTargetList(int len,int sum){
        ans=new ArrayList<>();
        findNDigitNums(len,sum,"", 0);
    }

}
