package practice.pracs;

public class FindFirstRepeatingInSortedArray {


    //iterative binary search
    public static int findRepeating(int[] arr){

        int l=0;
        int r=arr.length;
        int mid=0;
        return 0;

    }

    //iterative binary search


    public static void main(String[] args) {
        System.out.println(findRepeating(new int[]{1,2,3,4,5,5,5,5,5,6,6,6}));
        //find first repeatingTarget element from the array
        //1,2,3,4,5,5,5,5,5,6,6,6
//        System.out.println(firstRepeatingTarget(new int[]{0,1,2,3,4,4,4,4},4));


        System.out.println(lastRepeatingTarget(new int[]{0,1,2,3,4,4,4,4,5,5,5,5,6,6,6,6,8,9,10},4));
    }

    private static int lastRepeatingTarget(int[] arr, int target) {

        int index=-1;

        int left=0;
        int right=arr.length-1;

        while (left<=right){
            int mid=left+(right-left)/2;
            //0 1 2 3 4 5 6 7 8 9 10 11
            //1 2 3 4 5 6 6 6 6 8 9  10
            if(arr[mid]<=target){
                left=mid+1;
            }else {
                right=mid-1;
            }
            if(arr[mid]==target) index=mid;

        }

        return index;
    }

    private static int firstRepeatingTarget(int[] arr, int target) {

        int left=0;
        int right=arr.length-1;
        while (left<right){ //IMP
            int mid=left+(right-left)/2;
            System.out.println("mid"+mid);
            if(arr[mid]<target){
                left=mid+1;
            }else if(arr[mid]>=target){
                right=mid; //IMP
            }
            System.out.println("left: "+left);
            System.out.println("right: "+right);
        }

        return arr[left];
    }


}
