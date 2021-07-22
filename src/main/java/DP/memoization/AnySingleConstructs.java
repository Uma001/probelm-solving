package DP.memoization;

import java.util.ArrayList;
import java.util.List;

public class AnySingleConstructs {


    private static List<List<String>> allPossibleConstructs(String target, String[] bank) {
        if(target.equals("")) {

        List<List<String>> list = new ArrayList() {{
            add(new ArrayList<>());
        }};

        return list;
        }
        List<List<String>> resultList = new ArrayList<>();
        for (String word : bank) {
            if(resultList.size()==0){
                if (target.startsWith(word)) {
                    String suffix = target.substring(word.length());
                    List<List<String>> suffixWays = allPossibleConstructs(suffix, bank);

                    if(suffixWays.size()>0){
                        List<List<String>> targetList = new ArrayList<>(suffixWays);
                        targetList.forEach(l->l.add(word));
                        for (List<String> currentList : targetList) {
                            resultList.add(currentList);
                            return resultList;
                        }
                    }
                }
            }
        }

        return resultList;

    }

    public static void main(String[] args) {
        System.out.println(allPossibleConstructs("hello",new String[]{"hell","o"}));

        System.out.println(allPossibleConstructs("hello",new String[]{"he","l","lo","hello","hell","o"}));
    }


}