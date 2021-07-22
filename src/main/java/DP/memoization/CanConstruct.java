package DP.memoization;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {

    /*
    * worst case height of the tree--> length of the target string(m)
    * n-> number of words in the bank
    * TC- O(n^m)*m  multiplied by m due to substring operation
    * SC- (m*m) creating new Substring in every stack so O(m)
    *
    * Improved complexities
    *   n*m *m
    *   m*m
    * */


    private static boolean CanConstructMemo(String target, String[] bank, Map<String,Boolean> memo){
        if(memo.containsKey(target))return memo.get(target);
        if(target.equals(""))return true;
        //target doesn't start with any element of the word bank
        for(String word: bank){
            if(target.startsWith(word)){
                String suffix=target.substring(word.length());
                if(CanConstructMemo(suffix,bank, memo)){

                    memo.put(target,true);
                    return true;
                }
            }
        }
        memo.put(target,false);
        return false;
    }

    private static boolean CanConstruct(String target, String[] bank){

        if(target.equals(""))return true;
        //target doesn't start with any element of the word bank
        for(String word: bank){
            if(target.startsWith(word)){
                String suffix=target.substring(word.length());
                if(CanConstruct(suffix,bank)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(CanConstruct("abcdef",new String[]{"ab","cde","f"})+" : "+CanConstructMemo("abcdef",new String[]{"ab","cde","f"},new HashMap<>()));
        System.out.println(CanConstruct("abcdef",new String[]{"cde"})+" : "+CanConstructMemo("abcdef",new String[]{"cde"},new HashMap<>()));
        System.out.println(CanConstruct("eeeef",new String[]{"e"})+" : "+CanConstructMemo("eeeef",new String[]{"e"},new HashMap<>()));
        System.out.println(CanConstruct("eeeef",new String[]{"e","f"})+" : "+CanConstructMemo("eeeef",new String[]{"e","f"},new HashMap<>()));
        System.out.println(CanConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",new String[]{"e","ee","eeee"},new HashMap<>()));
        System.out.println(CanConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",new String[]{"e","ee","eeee"}));
    }
}
