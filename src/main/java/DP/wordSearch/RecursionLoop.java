package DP.wordSearch;

public class RecursionLoop {
     static int count=0;

    public static void main(String[] args) {
        fun2(0);
    }

    private static void fun(int i) {
        System.out.println(count +": "+i);
        count++;
        if(i==3){
            return;
        }

        fun(i+1);
        fun(i+1);
    }

    private static void fun2(int i) {
        i++;
        System.out.println(count +": "+i);
        count++;
        if(i==3){
            return;
        }

        fun(i);
        fun(i);
    }
}
