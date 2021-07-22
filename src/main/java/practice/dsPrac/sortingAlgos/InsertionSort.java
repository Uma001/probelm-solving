package practice.dsPrac.sortingAlgos;

import java.util.Arrays;

public class InsertionSort {

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


    public static class MergeSortAlgo {
        //Time Complexity: 2Tn/2 + theta n===> n*log(n)
        //space complexity: 0(n)



        public static void main(String[] args) {
            int arr[]=new int[]{1, 2, 3, 5, 7, 9, 0, 10, 9, 55,11,4,89};
            Arrays.stream(sortArray(arr, 0, arr.length-1)).forEach(l-> System.out.print(l+" "));
        }

        private static int[] sortArray(int[] arr, int start, int end) {
            //base case
            int mid;
            if (start < end) {
                mid = (start + end) / 2;

                System.out.println("calling sort1");
                sortArray(arr, start, mid);
                System.out.println("calling sort2");

                sortArray(arr, mid + 1, end);

                mergeArrays(arr, start, mid, end);
            }

            return arr;

        }

        private static void mergeArrays(int[] arr, int l, int mid, int r) {

            //size of 2 arrays
            int n1 = mid - l + 1;
            int n2 = r - mid;


            int left[] = new int[n1];
            int right[] = new int[n2];

            for (int index = 0; index < n1; ++index) {
                left[index] = arr[l + index];
            }
            for (int index = 0; index < n2; ++index) {
                right[index] = arr[mid + index + 1];
            }

            int i = 0, j = 0, k = l;
            while (i < n1 && j < n2) {
                if (left[i] <=right[j]) {
                    arr[k] = left[i];
                    i++;
                } else {
                    arr[k] = right[j];
                    j++;
                }
                k++;
            }
            while (i < n1) {
                arr[k] = left[i];
                i++;
                k++;
            }
            while (j < n2) {
                arr[k] = right[j];
                j++;
                k++;
            }

            for(int m=l;m<r;m++){
                System.out.print(arr[m]+" ");

            }
            System.out.println("***");


        }
    }
}
