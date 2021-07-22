package backtracking;

import java.util.*;

public class GenAllSubsequences {


    public static void genAllSubSequence(Set<ArrayList<Integer>> ans, int[] arr, ArrayList<Integer> current, int index){

        HashMap<Integer,Integer> set=new LinkedHashMap();
        if(index==arr.length-1){
            ans.add(current);
            return;
        }


        genAllSubSequence(ans, arr, current,index+1);
        ArrayList<Integer> ansCopy=new ArrayList<>(current);
        ansCopy.add(arr[index]);
        genAllSubSequence(ans, arr, ansCopy,index+1);


    }

    public static void main(String[] args) {
        Set<ArrayList<Integer>> list=new HashSet<>();
        genAllSubSequence(list, new int[]{1,2,3,4,5}, new ArrayList<>(), 0);
        list.forEach(System.out::println);
    }

}
