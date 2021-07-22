package backtracking;

public class CheckPallindrome {

    private static boolean checkIfPallindrom(String str, int left, int right){

        if(left>=right){
            return true;
        }
//        if(str.charAt(left)!=str.charAt(right)){
//            return false;
//        }
        return str.charAt(left)!=str.charAt(right) && checkIfPallindrom(str,left+1,right-1);
    }

    public static void main(String[] args) {
        String s="Hello";
        System.out.println(checkIfPallindrom(s,0,s.length()-1));
        s="NAMAN";
        System.out.println(checkIfPallindrom(s,0,s.length()-1));
    }

}
