package practice.dsPrac.sortingAlgos;

import java.util.Arrays;

public class InsertionSortWithBinarySearch {

    //insertion sort algo
    // for every element from i-1 to n-1, insert the element into its correct position by pairwise swapping between a[0: i-1]
    //so the array to the left of key element is always sorted

    //for every element n comparisons are happening to find its correct position

    public static void main(String[] args) {

        int arr[]= {3, 4, 5, 7, 9, 1, 2};
        int arr2[]= {7,72,90, 21 ,60};

        insertionSortArray2(arr2);

        System.out.println(Arrays.toString(arr2));
    }

    //slower
    //swap smaller elements with a[i]
    private static void insertionSortArray(int[] arr) {

        int key,index;
        for( index=1;index<arr.length;index++){
            key=arr[index];
            for(int j=index-1; j>=0;j--){
                if(key<arr[j]){
                    arr[index]=arr[j]; //swap
                    arr[j]=key;
                    index--; //since a[i] & a[j] are swapped, index of key(i) has to changed
                }else {
                    break;
                }
            }
        }

    }

    //faster
    //move all bigger elements one position ahead
    private static void insertionSortArray2(int[] arr) {

        int key,j;

        for(int index=1;index<arr.length;index++){

            key=arr[index];

            j=index-1;

            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }


    }


}
