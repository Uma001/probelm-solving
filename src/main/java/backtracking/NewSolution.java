package backtracking;

public class NewSolution {
    public static String solve(String A) {
        int len = A.length();
        char[] arr=A.toCharArray();
        int start=0;
        int end=0;
        //reverse each word
        //first how to find word end ?
        //keep start at first non empty
        //keep end at first empty
        //swap between start- end-1
        while(end<len){
            start=end;
            while(end<len && A.charAt(end)==' '){
                start++;
                end++;
            }
            while(end< len && A.charAt(end)!=' '){
                end++;
            }
            System.out.println(start+": "+end);
            rev(arr, start, end-1);
        }
        rev(arr, 0, len-1);

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<len;i++){
            if(i<len && arr[i]==' '){
                while(i+1<len-1 && arr[i+1]==' ')i++;
                sb.append(' ');
            }else{
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }

    private static void rev(char[] arr, int start, int end){

        for(int i=start;i<=end/2;i++){
            char temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(solve("hello "));

    }
}
