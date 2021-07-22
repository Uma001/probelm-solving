package practice.dsPrac.sortingAlgos;

public class HeapImpl {

//    Given an array of N elements. The task is to build a Binary Heap from the given array.
//    The heap can be either Max Heap or Min Heap.

    //heap property--root greater than left & right child

    //start heapifying from last non leaf node
    //why last non-leaf because leaf nodes are already heapified(heap-root greater than left and right child)
    //when u heapify an element and swapping happens then the heap of the swapped side may get broken so, call heapify on affected broken heap as well


    public static void main(String[] args) {

        int arr[] = {1, 3, 5, 4, 6, 13, 10,
                9, 8, 15, 17};

        int n = arr.length;

        buildHeap(arr, n);
        printHeap(arr, n);

    }

    private static void printHeap(int[] arr, int n) {

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void buildHeap(int[] arr, int n) {
        //start at non leaf
        int startIndex = (n / 2) - 1;

        for (int i = startIndex; i >= 0; i--) {
            heapifyArray(arr, n, i);
        }


    }

    private static void heapifyArray(int[] arr, int n, int i) {


        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int temp = 0;
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (i != largest) {
            temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapifyArray(arr, n, largest);
        }


    }


}
