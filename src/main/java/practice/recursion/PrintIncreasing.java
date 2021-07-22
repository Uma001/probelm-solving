package practice.recursion;

public class PrintIncreasing {

    public static void main(String[] args) {
        PrintIncreasingTillN(8);
    }

    private static void PrintIncreasingTillN(int n) {
//        1 2 3 4 5 6 7
        if(n==0) return;
        PrintIncreasingTillN(n-1); //once numbers till n-1 are printed
        System.out.println(n); //ill just print my last number, I have faith that number till n-1 will be printed properly
    }
}
