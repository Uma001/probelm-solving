package practice.pracs;

public class PallindromeAfterSwap {

    public static String solve(String A) {
        int l=0;
        int r=A.length()-1;
        int count=0;
        while(l<r){
            if(A.charAt(l)!=A.charAt(r)){
                count++;
            }
            l++;
            r--;
        }

        if(A.length()!=0){
            return count<=1 ? "YES":"NO";
        }else{
            return count==1 ? "YES":"NO";
        }


    }

    public static void main(String[] args) {
        System.out.println(solve("abba"));
    }

}
