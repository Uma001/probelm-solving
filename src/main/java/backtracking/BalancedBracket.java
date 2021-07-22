package backtracking;

public class BalancedBracket {

    private static void genBalancedBracket(int openRemainder,int closedRemainder, int n, String str){

        if(openRemainder==0 && closedRemainder==0){
            System.out.print(str+" ");
            return;
        }
//
        if(openRemainder>0){
            str=str+'(';
            openRemainder--;
            genBalancedBracket(openRemainder,closedRemainder,n,str);
        }
        System.out.print(closedRemainder+" ");
        if(closedRemainder>openRemainder){
            str=str+')';
            closedRemainder--;
            genBalancedBracket(openRemainder,closedRemainder,n,str);
        }

    }

    public static void main(String[] args) {
        genBalancedBracket(3,3,3,"");
    }


}
