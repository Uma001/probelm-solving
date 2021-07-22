package practice.dsPrac.sortingApplications;

public class CountInversion {
//    Inversion Count for an array indicates – how far (or close) the array is
//    from being sorted. If array is already sorted then inversion count is 0.
//    If array is sorted in reverse order that inversion count is the maximum.

    //application of merge sort

    public static void main(String[] args) {
        int[] arr = { 1, 20, 6, 4, 5 };

        System.out.println(getInversionCount(arr,0,arr.length-1));
    }

    private static int getInversionCount(int[] arr, int l, int r) {
        int invCount=0;
        if(l<r){

            int mid= (l+r)/2;

            invCount+=getInversionCount(arr,l,mid);
           invCount+= getInversionCount(arr,mid+1,r);

            invCount+=mergeAndGetInversionCount(arr,l,mid,r);
        }

        return invCount;

    }

    private static int mergeAndGetInversionCount(int[] arr, int l, int mid, int r) {
        int invCount=0;
        int leftSize=mid-l+1;
        int rightSize=r-mid;

        int left[] =new int[leftSize];
        int right[] = new int[rightSize];

        for (int i=0;i<leftSize;i++){
            left[i]=arr[l+i];
        }
        for (int i=0;i<rightSize;i++){
            right[i]=arr[mid+i+1];
        }

//        // Left subarray
//        int[] left = Arrays.copyOfRange(arr, l, m + 1);
//
//        // Right subarray
//        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i=0;
        int j=0;
        int k=l;

        while (i<leftSize && j<rightSize){
            if(left[i]>right[j]){
                arr[k]=right[j];
//                invCount=invCount+(mid-i);
                invCount += (mid + 1) - (l + i);  //imp********* eqw to mid-ith index

                j++;
            }else {
                arr[k]=left[i];
                i++;
            }
            k++;
        }




        return invCount;
    }




}

