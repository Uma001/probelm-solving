package practice.recursion;

public class Power {
    public static void main(String[] args) {
        int n=5;
        int x=3;
        System.out.println(power(n,x));

        System.out.println(logPower(n,x));
    }

    private static int logPower(int n, int x) {
        if(x==0){
            return 1;
        }
        int n_xhalf=logPower(n,x/2);
        int square=n_xhalf*n_xhalf;

        if(x%2==1){
            square*=n;
        }
        return square;

    }

    private static int power(int n,int x) {

        if(x==0){
            return 1;
        }
        return n*power(n,x-1);
    }



}
