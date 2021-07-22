package practice.pracs;

import java.util.HashMap;

public class BitManipulation {

    boolean isPowerOfTwo(int x)
    {
        // x will check if x == 0 and !(x & (x - 1)) will check if x is a power of 2 or not
        return ((x & (x - 1))==0);
    }

    public boolean isIsomorphic(String s, String t) {

        HashMap<Character,Character> seenPairs=new HashMap<Character,Character>();

        for(int i=0;i<s.length();i++){
            if(seenPairs.containsKey(s.charAt(i))){
                if(seenPairs.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }else if(seenPairs.containsValue(t.charAt(i))){
                if(seenPairs.get(t.charAt(i))!=s.charAt(i)){
                    return false;
                }
            }
//            seenPairs.add(s.charAt(i),t.charAt(i));
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(1 << 3);

        int ar[]=new int[]{1,2,3,4,5,6};

        for(int i=0;i<ar.length;i++){
            
        }

    }


}
