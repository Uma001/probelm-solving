package practice.pracs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MinlengthSubarrayOfMinMax {

    public static int solve(int[] A) {

        //get minimum and maximum in one pass
        int min=A[0];
        int max=A[0];
        int n=A.length;
        for(int i=1;i<n;i++){
            if(A[i]>max){
                max=A[i];
            }else if(A[i]<min){
                min=A[i];
            }
        }

        int smallestLength=Integer.MAX_VALUE;
        int minIndex=-1;
        int maxIndex=-1;
        for(int i=0;i<n;i++){
            if(A[i]==min){
                minIndex=i;
                if(maxIndex>=0){
                    smallestLength=Math.min(smallestLength,(minIndex-maxIndex+1));
                }
            }
            if(A[i]==max){
                maxIndex=i;
                if(minIndex>=0){
                    smallestLength=Math.min(smallestLength,(maxIndex-minIndex+1));
                }
            }
        }
        return smallestLength;
    }

    public static int firstUniqeChar(String s) {

        //bruteforce approach
//        int n=s.length();
//        for(int i=0;i<n;i++){
//            boolean isSeen=false;
//            for(int j=0;j<n;j++){
//
//                if(i!=j){
//                    if(s.charAt(i)==s.charAt(j)){
//                        isSeen=true;
//                        break;
//                    }
//                }
//            }
//            if(!isSeen){
//                return i;
//            }
//        }
//        return -1;


        if(s == null || s.length() == 0)
            return -1;

        int result = s.length();

        for(char c='a'; c <='z'; ++c) {
            int firstIdx = s.indexOf(c);
            if(firstIdx != -1 && firstIdx == s.lastIndexOf(c))
                result = Math.min(result, firstIdx);
        }

        return result == s.length()? -1 : result;
    }


    public static int[][] pattern1(int A) {

        int[][] arr=new int[A][];
        for(int row=0;row<A;row++){
            int inner[]=new int[row+1];
            int rowIndex=0;
            for(int value=1;value<row+1;value++){
                inner[rowIndex++]=value;
            }
        }
//        return arr;

        int[][] arr1=new int[A][];
        for(int row=0;row<A;row++){
            int temp[]=new int[row+1];
            int rowIndex=0;
            for(int value=1;value<=row+1;value++){
                temp[rowIndex++]=value;
            }
            arr1[row]=temp;
        }
//        return arr1;


//        for(int i=0;i<A;i++){
//            for(int j=0;j<A;j++){
//                System.out.print(arr1[i][j]);
//            }
//            System.out.println();
//        }

        for(int i=0;i<A;i++){
            for(int j=0;j<=i;j++){
                System.out.print(arr1[i][j]);
            }
            System.out.println();
        }
        return arr1;

    }



    public static int timeForMakingAllElementsEqual(int[] A) {
        int n=A.length;
        int max=A[0];
        for(int i=1;i<n;i++){
            max=Math.max(A[i],max);
            // max=A[0]>max?A[0]:max;
        }
        System.out.println(max);
        int count=0;
        for(int i=0;i<n;i++){
            count=count+(max-A[i]);
        }
        return count;
    }

    public static int goodPairs(int[] A, int B) {

        Set<Integer> set=new HashSet<>();
        int n=A.length;
        for(int i=0;i<n;i++){
            set.add(A[i]);
        }

        for(int i=0;i<n;i++){
            if(set.contains(B-A[i])){
                return 1;
            }
        }
        return 0;


    }
    public static void main(String args[]){
        System.out.println(goodPairs(new int[]{1,2,4},4));
        timeForMakingAllElementsEqual(new int[]{731, 349, 490, 781, 271, 405, 811, 181, 102, 126, 866, 16, 622, 492, 194, 735});
//        System.out.println(solve(new int[]{1,1,1,1}));
        System.out.println(pattern1(3));
        int array[][]=pattern1(5);
        for(int i=0;i<3;i++){
            for(int j=0;j<=i;j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
        System.out.println(firstUniqeChar("qqqqqqqqb"));
        HashMap<Integer,Integer>  map=new HashMap<>();
        map.put(1,1);
        map.put(2,2);

        System.out.println(map.get(3));
        System.out.println(new String("").length());


    }
}
