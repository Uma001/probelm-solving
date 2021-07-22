package backtracking;

import java.util.ArrayList;

public class genAllNDigNumsWithGivenSumTest {

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

    public static int solution(int N) {
        // write your code in Java SE 8
        if(N==0){
            //invalid input
            //this use case isn't defined in question so I just return -1
            return -1;
        }
        N=N<0?(N*-1):N;
        int currSumOfDigits=getDigitsSum(N);
        int nextValidNum=N+1;
        while (true){
            if(getDigitsSum(nextValidNum)==currSumOfDigits){
                break;
            }
            nextValidNum++;
        }
        return nextValidNum;
    }

    private static int getDigitsSum(int n){
        int sum=0;
        while (n!=0){
            sum+=n%10;
            n=n/10;
        }
//        System.out.println("int "+n+" : digit sum "+sum);
        return sum;

    }

    public static void main(String[] args) {

//        genNDigitNumsUtil(3,4);
//        System.out.println(solution(28));
//        System.out.println(solution(734));
//        System.out.println(solution(1990));
//        System.out.println(solution(10));
//        System.out.println(solution(3));
        System.out.println(solution(50000));

    }

    private static void genNDigitNumsUtil(int len,int sum) {
        ans=new ArrayList<>();
        genNDigitNums(len,sum,"",0);
    }
}
