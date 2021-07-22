package practice.recursion;

public class PrintDecreasingIncreasing {

    public static void main(String[] args) {
        DecreasingIncreasing(6);
    }

    private static void DecreasingIncreasing(int i) {

        if(i==0) return;

        System.out.print(i+" ");
        DecreasingIncreasing(i-1);
        System.out.print(i+" "); //when uppar wala function call starts returning from the base condition
    }
}
