package practice.dsPrac.sortingAlgos;

public class RadixSort {

    public static void main(String[] args) {

        int n=0;
        System.out.println((23/100)%10);

        int[] arr= {1,2,56,900,67,54,45,54};

        radixSort(arr);
    }

    private static void radixSort(int[] arr) {
        int digitsOfMax= getDigitsOfMax(arr,arr.length);


    }

    private static int getDigitsOfMax(int[] arr, int length) {
        int max=arr[0];
        for(int i=1;i<length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return (int) Math.log10(max);
    }

    private static int getDigitsCount(int n) {

//        int digit=0;
//        do{
//            digit++;
//            n=n/10;
//        }while(n>0);
//        return digit;

//        if(n==0){
//            return 0;
//        }
//        return 1+getDigitsCount(n/10);

//        return n==0? 1: (int) ((Math.log10(n)) + 1);

        return String.valueOf(n).length();

    }
}
