package practice.dsPrac;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        Arrays.stream(reverseArray1(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})).forEach(i-> System.out.print(i+" "));
        System.out.println();
        Arrays.stream(reverseArray2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})).forEach(i-> System.out.print(i+" "));

//        Arrays.stream(reverseArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})).forEach(i->System.out.println(i));
    }

    private static int[] reverseArray2(int[] arr) {
        int start=0;
        int end=arr.length-1;
        int temp;
        while (start<end){
            temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        return arr;

    }

    private static int[] reverseArray1(int[] array) {
        int temp;
       int index=0;
       int size=array.length;

       for(index=0; index<size/2; index++){
           temp=array[index];
           array[index]=array[size-index-1];
           array[size-index-1]=temp;
       }

//       for(int i=0; i<size;i++){
//           System.out.println(array[i]);
//
//       }

       return array;
    }
}
