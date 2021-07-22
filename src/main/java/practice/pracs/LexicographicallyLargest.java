package practice.pracs;

public class LexicographicallyLargest {

    /*
    You are given a string S. You want to change it to the lexicographically largest possible string by changing some of its characters.
    But you can only use characters of the string T as a replacement for characters of S. Formally,
     find the lexicographically largest string you can form by replacing some(or none) of the
     characters of S by using only the characters of string T. Note: Each character of T can be used at the most once.


     */

    public static String getLargest(String A) {

        String[] s=A.split("_");
        char[] original=s[0].toCharArray();
        char[] replacement =s[1].toCharArray();

        int[] freq=new int[26];

        for(char c:replacement){
            freq[c-'a']++;
        }

        int index=0;
        for(int i=25;i>=0;i--){
            while(freq[i]>0){
                char c=(char)(i+'a');
                if(index<original.length){
                    if(original[index]<c){
                        original[index]=c;
                        index++;
                        freq[i]--;
                    }
                }
            }
        }

        return String.valueOf(original);
    }

    public static void main(String[] args) {
        System.out.println(getLargest("z_p"));
    }
}
