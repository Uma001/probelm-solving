package backtracking;

import java.util.ArrayList;

public class genAllNDigNums {

    private static ArrayList<String> ans=null;

    private static void genNDigitNums(int num, String curr){

        if(curr.length()==num){
            System.out.println(curr);
            ans.add(curr);
            return;
        }

        for(int i=0;i<=9;i++){
            if(i!=0 || curr.length()!=0){
                genNDigitNums(num,curr+i);
            }
        }

    }

    public static void main(String[] args) {

        genNDigitNumsUtil(3);
    }

    private static void genNDigitNumsUtil(int num) {
        ans=new ArrayList<>();
        genNDigitNums(num,"");
    }
}
