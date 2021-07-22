package practice.pracs;

public class MultiDimensionalArray {

    public static int getIndex(int a[], int low, int high){
        if(high>=low){
            int mid=low+(high-low)/2;

            if((mid==0 || a[mid-1]==0) && a[mid]==1){
                return mid;
            }else if(a[mid]==0){
                //check right side of the array
                return getIndex(a,(mid+1),high);
            }else{
                //check left side of the array
                return getIndex(a, low, (mid-1));
            }
        }


        return -1;
    }


    public     static int first(int arr[], int low, int high)
    {
        if (high >= low) {
            // Get the middle index
            int mid = low + (high - low) / 2;

            // Check if the element at middle index is first 1
            if ((mid == 0 || (arr[mid - 1] == 0)) && arr[mid] == 1)
                return mid;

                // If the element is 0, recur for right side
            else if (arr[mid] == 0)
                return first(arr, (mid + 1), high);

                // If element is not first 1, recur for left side
            else
                return first(arr, low, (mid - 1));
        }
        return -1;
    }

    public static int solve(int[][] A) {

        int col=A[0].length;
        int row_with_max1=0;
        int first= getIndex(A[0], 0, col-1);

        if(first==-1){
            first=col-1;
        }

        int countOfOne=col-first;

        for(int i=1;i<col;i++){
            int currentOne=countOfOne;
            while(first>0 && A[i][first-1]==1){
                first--;
                currentOne++;
            }
            if(currentOne>countOfOne){
                row_with_max1=i;
            }
        }
        return row_with_max1;

    }

    public static void main(String[] args) {
        int arr[][]=new int[][]{
                {0, 0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1, 1}
        };

        System.out.println(solve(arr));
    }
}
