package DP.memoization;

import java.util.HashMap;
import java.util.Map;

/*
* n size of word bank
* m: target strings length
* TC O(n^m *m)
* SC: (m*m)
*
* Optimized
* TC: O(n*m)
* SC: O(m*m)
* */
public class CountConstruct {

    public  static int countConstructMemo(String target, String[] bank, Map<String,Integer> memo){

        if(memo.containsKey(target)){
            return memo.get(target);
        }

        if(target.equals("")){
            return 1;
        }
        int totalCount=0;
        for(String word:bank){
            if(target.startsWith(word)){
                String suffix=word.substring(word.length());
                int currentConstructCount=countConstructMemo(suffix,bank,memo);
                totalCount+=currentConstructCount;
            }
        }
        memo.put(target,totalCount);
        return totalCount;

    }

    public  static int countConstruct(String target, String[] bank){


        if(target.equals("")){
            return 1;
        }
        int totalCount=0;
        for(String word:bank){
            if(target.startsWith(word)){
                String suffix=word.substring(word.length());
                int currentConstructCount=countConstruct(suffix,bank);
                totalCount+=currentConstructCount;
            }
        }

        return totalCount;

    }
    public static void main(String[] args) {
        System.out.println(countConstruct("abcdef",new String[]{"ab","cde","f","abcdef","abcde"}));
        System.out.println(countConstruct("abcdef",new String[]{"ab","cde"}));
        System.out.println(countConstruct("abcdef",new String[]{"ab","cde","f"})+" : "+countConstructMemo("abcdef",new String[]{"ab","cde","f"},new HashMap<>()));
        System.out.println(countConstruct("abcdef",new String[]{"cde"})+" : "+countConstructMemo("abcdef",new String[]{"cde"},new HashMap<>()));
        System.out.println(countConstruct("eeeef",new String[]{"e"})+" : "+countConstructMemo("eeeef",new String[]{"e"},new HashMap<>()));
        System.out.println(countConstruct("eeeef",new String[]{"e","f"})+" : "+countConstructMemo("eeeef",new String[]{"e","f"},new HashMap<>()));
        System.out.println(countConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",new String[]{"e","ee","eeee","eeeeeeee","f"},new HashMap<>()));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",new String[]{"e","ee","eeee","eeeeeeee","f"}));
    }
}
