package practice.recursion;

public class PrintDecreasing {

    public static void main(String[] args) {
        PD(5);
    }

    private static void PD(int n) {
        if(n==0) return;
        System.out.println(n);
        PD(n-1);
    }
}
