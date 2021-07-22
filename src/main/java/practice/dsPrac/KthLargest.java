package practice.dsPrac;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {

    //sort the array and get n-kth element ---nlogn

    //use min heap and poll the queue once the queue's size exceeds k time complexity: linear plus space complexity of heap min/max

    public static void main(String[] args) {
        int arr[] = {8, 9, 10, 23, 45, 6, 1, 2, 3, 88}; //88,45,23,10
        System.out.println("4th largest num is: "+findKthLargest(arr, 4));
        System.out.println(("4th smallest num is: "+findKthSmallest(arr, 4)));
    }

    private static int findKthSmallest(int[] arr, int k) {
        //max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                System.out.println("deleting greater number so far: "+pq.peek());
                pq.poll();
            }

        }


        return pq.peek();
    }

    private static int findKthLargest(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                System.out.println("deleting smallest number so far: "+pq.peek());
                pq.poll();
            }
        }

        System.out.println(pq);
        return pq.peek();

    }


}
