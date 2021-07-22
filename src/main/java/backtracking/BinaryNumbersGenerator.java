package backtracking;

import java.util.ArrayList;

public class BinaryNumbersGenerator {

    static ArrayList<Integer> ans;
    private static void genBinaryNumbers(int len, String str){

        if(len==0){
            ans.add(convertToInteger(str));
            System.out.println(str+" : "+convertToInteger(str));
            return;
        }

        genBinaryNumbers(len-1,str+"0");
        genBinaryNumbers(len-1,str+"1");

    }

    private static int convertToInteger(String str) {
        int num=0;

        for(int i=0;i<str.length();i++){
            num=num*2+(str.charAt(i)-'0');
        }


        return num;
    }

    public static void main(String[] args) {
        ans=new ArrayList<>();
        genBinaryNumbers(4,"");
    }
}
