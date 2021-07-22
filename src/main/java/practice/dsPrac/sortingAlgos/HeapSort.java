package practice.dsPrac.sortingAlgos;

public class HeapSort {


    //create a max heap from input data
    //at this point, the root element of the heap is going to be the largest element, so swap it with last item of the heap and reduce heap size by 1.
    //repeat step 1 & 2 while heap size is greater than 1

    public static void main(String[] args) {
        int arr[] = {
                1, 3, 5, 4, 6, 13, 10,
                9, 8, 15, 17
        };

        int n=arr.length;

        heap_sort(arr,n);

       printSortedArray(arr,n);
    }

    private static void heap_sort(int[] arr, int n) {

        build_heap(arr, n );

        int temp;
        for(int i=n-1;i>=0;i--){
            temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            heapify(arr,i,0);
        }
    }

    private static void printSortedArray(int[] arr, int n) {

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void build_heap(int[] arr, int n) {
        int startIndex=(n/2)-1;
        for(int i=startIndex;i>=0;i--){
            heapify(arr,n,i);
        }
    }

    private static void heapify(int[] arr, int n, int i) {

        int largest=i;
        int l=2*i+1;
        int r=2*i+2;

        if(l<n && arr[l]>arr[largest]){
            largest=l;
        }

        if(r<n && arr[r]>arr[largest]){
            largest=r;
        }
        int temp;
        if(largest!=i){
            temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;

            heapify(arr,n,largest);
        }
    }
}
