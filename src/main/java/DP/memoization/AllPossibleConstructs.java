package DP.memoization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
*  m target length n: number of words in the bank
*
* TC: n^m * think of the number of sub arrays you'll return in worst case (n^m)
* SC: O(m)
*
*
* */

public class AllPossibleConstructs {


    private static List<List<String>> allPossibleConstructs(String target, String[] bank) {
        if(target.equals("")) {

        List<List<String>> list = new ArrayList() {{
            add(new ArrayList<>());
        }};

        return list;
        }
        List<List<String>> resultList = new ArrayList<>();
        for (String word : bank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allPossibleConstructs(suffix, bank);
                List<List<String>> targetList = new ArrayList<>(suffixWays);
                targetList.forEach(l->l.add(word));
                for (List<String> currentList : targetList) {
                    resultList.add(currentList);
                }
            }

        }

        return resultList;

    }

    private static List<List<String>> allPossibleConstructsMemo(String target, String[] bank,
                                                                Map<String, List<List<String>>> memo) {
        if(memo.containsKey(target))return memo.get(target);
        if(target.equals("")) {

            List<List<String>> list = new ArrayList() {{
                add(new ArrayList<>());
            }};

            return list;
        }
        List<List<String>> resultList = new ArrayList<>();
        for (String word : bank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allPossibleConstructsMemo(suffix, bank, memo);
                List<List<String>> targetList = new ArrayList<>(suffixWays);
                targetList.forEach(l->l.add(word));
                for (List<String> currentList : targetList) {
                    resultList.add(currentList);
                }
            }

        }

        memo.put(target,resultList);
        return resultList;

    }


    public static void main(String[] args) {

        System.out.println(allPossibleConstructs("hello",new String[]{"he","l","lo","o"}));

        System.out.println(allPossibleConstructs("hello",new String[]{"hell","o"}));

        System.out.println(allPossibleConstructs("hello",new String[]{"he","l","lo","hello","hell","o"}));
    }


}