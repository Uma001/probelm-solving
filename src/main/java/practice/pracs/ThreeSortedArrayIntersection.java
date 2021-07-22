package practice.pracs;

import java.util.ArrayList;
import java.util.List;

public class ThreeSortedArrayIntersection {

    /*
    given 3 sorted arrays in strickty increasing order,
    return a sorted array of only integers that appeared in all three arrays

    1 2 3   second bigger than 1st i++
    1 3 2   second bigger than 1st i++
    2 1 3   second smaller than 1st j++
    2 3 1   second bigger than 1st i++
    3 2 1   second smaller than 1st j++
    3 1 2
    AT LAST 1ST & 2ND WILL BECOME EQUAL SO K++
     */

    public static List<Integer> findIntersection(int[] arr1, int[] arr2, int[] arr3) {

        int i = 0;
        int j = 0;
        int k = 0;
        List<Integer> ans = new ArrayList<>();
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                ans.add(arr1[i]);
                i++;
                j++;
                k++;
            }else if(arr1[i]<=arr2[j]){
                i++;
            }else if(arr1[i]>=arr2[j]){
                j++;
            }else {
                k++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findIntersection(new int[]{1,2,3,4,5,6,7,8,9},
                new int[]{5,6,7,8,9},
                new int[]{5,8,9,10}));
    }
}
