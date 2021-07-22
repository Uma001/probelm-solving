package practice.pracs;

import java.util.HashMap;
import java.util.Map;

public class RepetingSmallestIndex {

        public static int solve(int[] A) {

            Map<Integer, Integer> map=new HashMap<>();

            map.put(A[0],0);
            int index=-1;
            int smallest=Integer.MAX_VALUE;
            for(int i=1;i<A.length;i++){
                if(map.containsKey(A[i]) && smallest>A[i]){
                    index=i-map.get(A[i]);
                    smallest=A[i];
                }else{
                    map.put(A[i],i);
                }
            }

            return index;
        }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{0,1,0}));
    }
}
