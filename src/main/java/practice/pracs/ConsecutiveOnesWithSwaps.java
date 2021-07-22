package practice.pracs;

public class ConsecutiveOnesWithSwaps {

    public static int solve(String A) {

        int n=A.length();


        char  arr[]=A.toCharArray();
        int left[]=left(arr);
        int right[]=right(arr);

        int totalOnes=count(arr, n);
        int ans=0;
        for(int i=0;i<n;i++){

            if(arr[i]=='0'){
                int l=left[i];
                int r=right[i+1];

                if(l+r<totalOnes){
                    ans=Math.max(ans,l+r+1);
                }else{
                    ans=Math.max(ans,l+r);
                }
            }
        }

        return ans;
    }

    public static int count(char a[],int n){
        int count=0;
        for(int i=0;i<n;i++){
            if(a[i]=='1'){
                count++;
            }
        }

        return count;
    }

    public static int[] left(char a[]){
        int n=a.length;
        int count=a[0]=='0'?0:1;
        int c[]=new int[n+1];
        c[0]=count;
        for(int i=1;i<n;i++){

            if(a[i]=='1'){
                count++;
            }else{
                count=0;
            }

            c[i]=count;
        }

        return c;
    }

    public static int[] right(char a[]){
        int n=a.length;
        int count=0;
        int c[]=new int[n+1];

        c[n]=0;
        for(int i=n-1;i>0;i--){

            if(a[i]=='1'){
                count++;
            }else{
                count=0;
            }
            c[i]=count;

        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(solve("010100110101"));
    }
}
