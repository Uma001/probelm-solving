package practice.pracs;


import java.util.HashMap;
import java.util.Map;

/*
Longest substring length with 'k' distinct characters

for k=2
AAAABBBBBBBB
AAAABBBBBBBBC
AAAABBBBBBBBCCCCCCCCCCCCCCCC

 */
public class LongestSubstringLengthWithKDistinctChar {


//    ABCDEFGGGHIJKLMNOP

    public static int longestLengthWithKChar(char[] c, int k) {
        Map<Character, Integer> map = new HashMap<>();

//        int length=0;
        int maxLength = Integer.MIN_VALUE;
        int left = 0;
        for (int i = 0; i < c.length; i++) {
            map.put(c[i], map.getOrDefault(c[i], 0) + 1);

            while (map.size() > k) {
                char ch = c[left];
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
                left++;
            }
            maxLength = Math.max(maxLength, i - left + 1);

        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestLengthWithKChar("AAAABBBBBBBBCCCCCCCCCCCCCCCC".toCharArray(), 2));
        System.out.println(longestLengthWithKChar("AAAABBBBBBBBCCCCCCCCCCCCCCCCD".toCharArray(), 3));
        System.out.println(longestLengthWithKChar("AAAABBBBBBBBCCCCCCCCCCCCCCCC".toCharArray(), 3));
        System.out.println(longestLengthWithKChar("AAAAAAAAA".toCharArray(), 0));
        System.out.println(longestLengthWithKChar("ABBBC".toCharArray(), 3));
    }
}
