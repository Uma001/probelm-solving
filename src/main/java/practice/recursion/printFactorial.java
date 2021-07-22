package practice.recursion;

public class printFactorial {

    public static void main(String[] args) {
        int n=10;
        System.out.println(fact(n));
    }

    private static int fact(int n) {

        if(n==0){
            return 1;
        }
        return n*fact(n-1);
    }
}
