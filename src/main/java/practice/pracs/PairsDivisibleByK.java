package practice.pracs;

import java.util.HashSet;
import java.util.Set;

public class PairsDivisibleByK {


        public static int solve(int[] A, int B) {

            Set<Integer> set=new HashSet<>();
            int rem=0,pairs=0;
            for(int n:A){
                rem=n%B;
                if(set.contains(B-rem)) pairs++;
                set.add(rem);
            }

            return pairs;
        }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1,2,3,4,5},2));
    }
}
