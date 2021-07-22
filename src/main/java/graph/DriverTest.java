package graph;

public class DriverTest {

    public static void main(String[] args) {
        long[] a1={1,2,3};
        long[] a2=fix(a1);
        for(long n:a1){
            System.out.print(n+" ");
        }

        for(long n:a2){
            System.out.print(n+" ");
        }

    }

    private static long[] fix(long[] a1) {

        a1[1]=8;

        return a1;
    }
}
