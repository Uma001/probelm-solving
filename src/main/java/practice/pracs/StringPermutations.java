package practice.pracs;

import java.util.HashMap;
import java.util.Map;

public class StringPermutations {

    public static int solve(String A, String B) {
        Map<Character,Integer> freq=new HashMap<>();
        int n=A.length();
        int m=B.length();

        if(B.length()<A.length()){
            return 0;
        }
        for(int i=0;i<n;i++){
            char c=A.charAt(i);
            freq.put(c,freq.getOrDefault(c,0)+1);
        }

        int i=0;
        int j=n-1;
        int count=0;
        HashMap<Character, Integer> map=new HashMap<>();

        for(int left=0;left<n;left++){
            char c=B.charAt(left);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        while(i<m-n && j <m-1){

            if(map.equals(freq)){
                count++;
            }
            if(map.get(B.charAt(i))>1){
                map.put(B.charAt(i),map.get(B.charAt(i))-1);
            }else {
                map.remove(B.charAt(i));
            }
            i++;
            j++;
            map.put( B.charAt(j),map.getOrDefault(B.charAt(j),0)+1);

        }
        if(map.equals(freq)){
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(solve("aca","acaa"));


    }


}
