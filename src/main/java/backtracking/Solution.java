package backtracking;

import java.util.*;


public class Solution {

    static Map<Integer, String> map = new HashMap<>();
    static ArrayList<String> ans=null;



    public static ArrayList<String> letterCombinations(String A) {
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        int prod=1;
        for(int i=0;i<A.length();i++){
            prod*=map.get(A.charAt(i)-'0').length();
        }
        ans=new ArrayList(prod);
        Solution.rec( A, "", 0 );

        return ans;


    }

    static void rec(String A , String curr, int id){

        if(id>A.length()){
            return;
        }

        if(curr.length()==A.length()){
            ans.add(curr);
            return;
        }

        for(int i=id;i<A.length();i++){
            String s=map.get(A.charAt(i)-'0');
            for(int j=0;j<s.length();j++){
                Solution.rec(A, curr+s.charAt(j),   id+1 ) ;
            }
        }

    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int ans=0;
        Set<Integer> numSet=new HashSet<>();
        for(int num: A){
            numSet.add(num);
        }
        for(int i=0;i<A.length;i++){
            int target=0-A[i];
            if(numSet.contains(target)){
                if(target>ans){
                    ans=target;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        letterCombinations("23");
//
//
//        for (String s:ans){
//            System.out.print(s+" ");
//        }
        System.out.println(solution(new int[]{1,1,-1,-1,2,-2,0,-19,19}));
        System.out.println(solution(new int[]{0,0,0,0,0,0}));
        System.out.println(solution(new int[]{1,1,1,1,1}));
        System.out.println(solution(new int[]{-1,-1,-1,-1,-1}));
    }

//    ad ae af bd be bf cd ce cf

}

