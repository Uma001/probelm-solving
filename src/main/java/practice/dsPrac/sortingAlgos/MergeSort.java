package practice.dsPrac.sortingAlgos;

import java.util.Arrays;

public class MergeSort {

    //time complexity nlogn
    //complexity to merge 2 sorted array --n

    //space complexity : n (left & right array that keeps the array copy)

//    TODO write down in place merge sort


    public static void main(String[] args) {

        int arr[]={2,4,90,1,7,5,9,6,31,11};
        System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length-1)));
    }

    private static int[] mergeSort(int[] arr, int l, int r) {

        int mid=0;
        if(l<r){

             mid=(l+r)/2;

            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);

            merge(arr,l,mid,r);
        }


        return arr;



    }

    private static int[] merge(int[] arr, int l, int mid, int r) {

//        int leftSize= mid-l+1;
//        int rightSize=r-mid;
//
//        int left[]= new int[leftSize];
//        int right[]=new int[rightSize];

        int leftSize=mid-l+1;
        int rightSize=r-mid;

        int left[] =new int[leftSize];
        int right[] = new int[rightSize];

        for(int index=0;index<leftSize;index++){
            left[index]=arr[index+l];
        }
        for(int index=0;index<rightSize;index++){
            right[index]=arr[index+mid+1];
        }

        int i=0,j=0,k=l;

        while (i<leftSize && j<rightSize){

            if(left[i]>right[j]){
                arr[k]=right[j];
                j++;
            }else {
                arr[k]=left[i];
                i++;
            }
            k++;
        }

        while(i<leftSize){
            arr[k]=left[i];
            i++;
            k++;
        }

        while (j<rightSize){
            arr[k]=right[j];
            j++;
            k++;
        }

        return arr;
    }
}
