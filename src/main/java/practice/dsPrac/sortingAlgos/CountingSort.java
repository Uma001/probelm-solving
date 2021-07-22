package practice.dsPrac.sortingAlgos;

import java.util.Arrays;

public class CountingSort {

   /* Steps in Couting Sort
    Take a count array to store the count of each unique object.
    Modify the count array such that each element at each index stores the sum of previous counts.
    The above modified count array shows the position of each object in the sorted output
    Output each object from input sequence(into index coming from updated count array, ) followed by decreasing the count by 1


   create a count array and store count of each element in this array where element of original arrays are index of count array
   create sumCount array where sumCount[i]=sumCount[i-1]+count[i] sumCount[0]=count[0]
   create another array to store sorted elements,
   originalArray[i] goes at index sumCount[originalArray[i]] and sumCount[originalArray[i]]=sumCount[originalArray[i]]-1

   Time Complexity: O(n+k) where n is the number of elements in input array and k is the range of input.
   Auxiliary Space: O(n+k)

    */


    public static void main(String[] args) {
        int[] arr={0,1,2,4,5,6,3,4,4,9,10,-9,-1,-18};
        countSort(arr);
        printArray(arr);
    }

    private static void printArray(int[] arr) {

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void countSort(int[] arr) {

        int min=Arrays.stream(arr).min().getAsInt();

        int max= Arrays.stream(arr).max().getAsInt();

        //create count array
        int range=max-min+1;
        int count[]=new int[range];
        int output[]=new int[arr.length];
        for(int i=0;i<range;i++){
            count[i]=0;
        }
        for(int i=0;i<arr.length;i++){
            count[arr[i]-min]++; //where arr[i] is gonna get placed in the count array
        }
        for(int i=1;i<range;i++){
            count[i]=count[i-1]+count[i];
        }
        for(int i=0;i<arr.length;i++){
            output[count[arr[i]-min]-1]=arr[i];
            count[arr[i]-min]--;
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=output[i];
        }


    }

}
