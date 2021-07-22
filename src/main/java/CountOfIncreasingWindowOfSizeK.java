public class CountOfIncreasingWindowOfSizeK {

    public static int countOfIncWindows(int[] arr, int K){
        int ans=0;
        int len=arr.length;
        int end=0;
        int counter=1;

        while (end<len){
            while(counter <K && end<len-1 && arr[end]<arr[end+1]){
                counter++;
                end++;
            }
            if(counter==K){
                counter--;
                ans++;
            }else {
                counter=1;
                end++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(countOfIncWindows(new int[]{1,2,3,4},4));
        System.out.println(countOfIncWindows(new int[]{5,3,5,7,8},3));
        System.out.println(countOfIncWindows(new int[]{5,1,2,3,4,1,0,6,7,8,9},4));
        System.out.println(countOfIncWindows(new int[]{1,2,3,4,5},4));
        System.out.println(countOfIncWindows(new int[]{1,2,3,4,5,6},4));
    }
}
