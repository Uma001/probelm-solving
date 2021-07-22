package practice.pracs;

import java.util.HashMap;
import java.util.Map;

public class CountOfPairsWithSumK {

    public static int countOfPairs(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n:arr){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int count = 0;
        for(int n:arr){
            if(map.containsKey(k-n)){
                count+=map.get(k-n);
                if(k-n==n) count--; //when u see k-n freq, n is also included(current n has also contributed to freq)
                // so we need to remove that as single n cannot be counted as a pair
            }
        }
        return count/2;
    }

    public static void main(String[] args) {
        System.out.println(countOfPairs(new int[]{1,3},4));

        System.out.println(countOfPairs(new int[]{5,5},10));//for if(k-n==n) count--;
        //1, 1, 1, 1  4
        //
        //1
        // 1-5,5 2
        // 5-1 1
        //5-1 1
    }
}
