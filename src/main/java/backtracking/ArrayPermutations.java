package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ArrayPermutations {

    /*
    * Generate all possible permutations of an array
    * Idea: for every element, you've got n places you can can put it at
    * so, swap element with every other element to its right
    *
    * */

    static void genArrayPermutations(int[] arr, int index, ArrayList<int[]> res){

        //last swap will be done for n-1th index (last element that you fix is n-1th element)
        //no need to swap nth element (even if you wanna swap it,
        // you could only swap with itself-that wouldn't give you any new permutation so return when index=n-1)

        if(index==arr.length-1){

            int[] perm1=new int[]{};
            perm1=arr.clone();
            res.add(perm1);
            return;
        }

        for(int i=index;i<arr.length;++i){
            if(arr[index]==arr[i] && i!=index){
                continue; //no point in swapping n with n
            }
            swap(arr,index,i);
            genArrayPermutations(arr,index+1,res);
            swap(arr,index,i);
        }

    }

    private static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        ArrayList<int[]> ans = new ArrayList<>();
        genArrayPermutations(new int[]{1,2,3}, 0,ans);

        System.out.println(ans.size());

        for(int[] arr:ans){
            Arrays.stream(arr).forEach(el->System.out.print(el+" "));
            System.out.println();
        }

        ArrayList<int[]> list=new ArrayList<>(new HashSet<>(ans));

        System.out.println(list.size());
    }
}
