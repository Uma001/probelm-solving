import java.util.LinkedList;
import java.util.Queue;

public class CountPairSumDivisibleByK {

    public static int solve(int[] A, int K) {

        long[] remFr=new long[K];
        int n=A.length;
        for(int i=0;i<n;i++){
            remFr[A[i]%K]++;
        }

        int half=K/2;
        long count=0;
        for(int i=1;i<=half && i!=K-i;i++){ //dont count for mid element when K is even so i!=K-i
            count+=remFr[i]*remFr[K-i];
        }

        if(K%2==0){
            count+=(remFr[K/2]*(remFr[K/2]-1))/2;
        }
        // else{
        //     if(i<K-1){
        //         count+=remFr[i]*remFr[K-i];
        //     }
        // }

        count+=(remFr[0]*(remFr[0]-1))/2;

        int x=0;
        return x=5;
//        return (int)(count%((int)Math.pow(10,9)+7));

    }

    public static void main(String[] args) {
//        System.out.println(solve(new int[]{1,2,3,4,5,6,7},5));

        System.out.println(justCheck());
    }

    private static int justCheck() {

        Queue q=new LinkedList();
//        q.add()
        int x;
        return x=1888;
    }
}
