package practice.pracs;

public class GCD {

    private static int GCDEuclidean(int n, int m){

//        if(n<m){
//            GCDEuclidean( m, n);
//        }
        while (m!=0){ //continue until smaller number is not zero
            int rem=m; //m is the smaller number
            rem=n%m;
            n=rem;
        }
        return n;
    }

    private static int GCDBruteForce(int n, int m){

        if(n==0){
            return m;
        }
        if (m==0){
            return n;
        }
        int min=Math.min(n,m);
        if(n%min==0 && m%min==0){
            return min;
        }

        for(int i=min/2;i>=2;i--){
            if(n%i==0 && m%i==0){
                return i;
            }
        }
        return 1;
    }

    private static int GCDRecursive(int n, int m) {
        if(m==0) return n;
        return GCDRecursive(m,n%m);

    }

    public static void main(String[] args) {

        System.out.println("GCD Euclidean: "+GCDEuclidean(5,18));
        System.out.println("GCD Bruteforce: "+GCDBruteForce(5,18));
        System.out.println("GCD Recursive: "+GCDRecursive(5,18));
    }


}
