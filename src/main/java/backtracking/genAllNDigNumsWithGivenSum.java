package backtracking;

import java.util.ArrayList;

public class genAllNDigNumsWithGivenSum {

    private static ArrayList<String> ans=null;

    private static void genNDigitNums(int len,int sum, String curr, int currNum){

        if(currNum>sum){
            return;
        }
        if(curr.length()==len){
            if(currNum==sum){
                System.out.println(curr);
//                ans.add(curr);
            }
            return;
        }


        for(int i=0;i<=9;i++){
            if(i!=0 || curr.length()!=0){
                genNDigitNums(len,sum,curr+i,currNum+i);
            }
        }

    }

    public static void main(String[] args) {

        genNDigitNumsUtil(3,4);

    }

    private static void genNDigitNumsUtil(int len,int sum) {
        ans=new ArrayList<>();
        genNDigitNums(len,sum,"",0);
    }
}
