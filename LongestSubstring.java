import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sunmit9 on 03/04/17.
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println("Length of longest substring = " + lengthOfLongestSubstringHashSet("pwwwkew"));
    }

    public static int[] lengthOfLongestSubstring(String s) {

        // create a new list that will store the length of non-repeating substring from the indexed character in string.
        int[] lengthList = new int[s.length()];
        for(int i = 0; i< s.length(); i++){
            Set<String> charSet = new HashSet<>();
            for(int j = i; j<s.length() ;j++){
                if(charSet.contains(String.valueOf(s.charAt(j)))){
                    break;
                }
                charSet.add(String.valueOf(s.charAt(j)));
                lengthList[i] = lengthList[i]+1;
            }
        }
        return lengthList;
    }

    public static int lengthOfLongestSubstringOhOfN(String s) {

        // create a new list that will store the length of non-repeating substring from the indexed character in string.
        Map<Character, Integer> charSet = new HashMap<>();
        int max=0;
        for(int i = 0, j=0 ; j < s.length(); ++j){
            if(charSet.containsKey(s.charAt(j))){
                i = Math.max(i, charSet.get(s.charAt(j)) + 1);
            }
            charSet.put(s.charAt(j), j);
            max = Math.max(max, j-i+1);
        }
        return max;
    }


    public static int lengthOfLongestSubstringHashSet(String s){
        int max = 0;
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
}
