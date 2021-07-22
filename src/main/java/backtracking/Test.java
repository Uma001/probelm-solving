package backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Parent{
    Parent(int i){
        System.out.println("PARENT CONSTRUCTOR");
    }

    public static void   test(){
        System.out.println("PARENT STATIC");
    }
}

class Child extends Parent{

    Child(int i) {
        super(i);
    }
    public static void   test(){
        System.out.println("CHILD STATIC");
    }
//    Child(){
//        super(0 );
//        System.out.println();
//    }
}

public class Test {

//    public static void display(Number t){
//        System.out.println("TEST");
//    }

    public static void display(Integer t){
        System.out.println("Integer");
    }

//    public static void display(int i){
//        System.out.println("int primitive");
//    }
//
//    public static void display(long i){
//        System.out.println("long primitive");
//    }

//    public static void display(Long i){
//        System.out.println("long wrapper");
//    }

//    public static void display(String i){
//        System.out.println("long primitive");
//    }

    public static void main(String[] args) {

        byte b=2;

        String s="";

        Queue<Integer> q=new LinkedList<>();
        Parent p=new Child(1); //static methods are called based on reference variable
        p.test();
    }


}
