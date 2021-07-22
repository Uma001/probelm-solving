package practice.dsPrac;


public class MinAndMaxFromArray {

    static class MinMax {

        int min;
        int max;

        @Override
        public String toString() {
            return "MinMax{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println("Linear : "+getMinAndMax(new int[]{9, 89, 2, 3, 90, 76, 11, 111, 0, 2}));//linear
        System.out.println("Divide and conquer: "+getMinAndMaxTournament(new int[]{9, 89, 2, 3, 90, 76, 11, 111, 0, 2}, 0, 9));//Divide and Conquer
        System.out.println("Pairs Approach: "+getMinAndMaxPairsAppraoch(new int[]{9, 89, 2, 3, 90, 76, 11, 111, 0, 2}));
    }

    private static MinMax getMinAndMaxPairsAppraoch(int[] arr) {

        //if even number of elements then compare pairs starting with index 2
        //iif odd number of elements then start with pairs from index 1

        int size= arr.length;
        int index;
        MinMax minmax=new MinMax();
        if(size%2==0){
            if(arr[0]>arr[1]){
                minmax.max=arr[0];
                minmax.min=arr[1];
            }
            index=2;
        }else {
            minmax.min=arr[0];
            minmax.max=arr[0];
            index=1;
        }

        while (index<size-2){
            if(arr[index]>arr[index+1]){
                if(minmax.max<arr[index]){
                    minmax.max=arr[index];
                }
                if(arr[index+1]<minmax.min){
                    minmax.min=arr[index+1];
                }
            }else {

                if(minmax.max<arr[index+1]){
                    minmax.max=arr[index+1];
                }

                if (arr[index]<minmax.min){
                    minmax.min=arr[index];
                }
            }
            index+=2;
        }


        return minmax;

    }

    private static MinMax getMinAndMaxTournament(int[] arr, int start, int end) {
        MinMax minMax = new MinMax();
        MinMax mml = new MinMax();
        MinMax mmr = new MinMax();
        int mid;

        if (start == end) {
            minMax.min = arr[start];
            minMax.max = arr[end];
            return minMax;
        }else if(end==start+1){
            if(arr[end]>arr[start]){
                minMax.min=arr[start];
                minMax.max=arr[end];
            }else {
                minMax.min=arr[end];
                minMax.max=arr[start];
            }
            return minMax;
        }
        mid = (start + end) / 2;
        mml=getMinAndMaxTournament(arr,start,mid);
        mmr=getMinAndMaxTournament(arr, mid+1,end);

        if(mml.min<mmr.min){
            minMax.min=mml.min;

        }else {
            minMax.min=mmr.min;
        }

        if(mml.max>mmr.max){
            minMax.max=mml.max;
        }else {
            minMax.max=mmr.max;
        }

        return minMax;
    }

    private static MinMax getMinAndMax(int[] arr) {
        MinMax minMax = new MinMax();
        int index = 0;
        minMax.min = Integer.MAX_VALUE;
        minMax.max = 0;
        int size = arr.length;
        if (size == 1) {
            minMax.min = arr[0];
            minMax.max = arr[0];
        } else {
            for (index = 0; index < size; index++) {
                if (minMax.min > arr[index]) {
                    minMax.min = arr[index];
                } else if (minMax.max < arr[index]) {
                    minMax.max = arr[index];
                }
            }
        }

        System.out.println(minMax.min + " " + minMax.max);

        return minMax;

    }
}
