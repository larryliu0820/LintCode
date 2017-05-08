import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valued Customer on 3/20/2017.
 *
 * Longest Substring with At Most K Distinct Characters
 *
 * Given a string s, find the length of the longest substring T that contains at most k distinct characters.
 *
 * Example
 For example, Given s = "eceba", k = 3,

 T is "eceb" which its length is 4.
 */
public class p386 {
    /**
     * @param s : A string
     * @return : The length of the longest substring
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null || s.length() == 0 || k == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int maxLen = 1;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            char leftChar = s.charAt(left);
            if (map.size() < k || (map.size() == k && map.containsKey(rightChar))) {
                maxLen = Math.max(maxLen, right - left + 1);
                if (!map.containsKey(rightChar)) map.put(rightChar, 0);
                map.put(rightChar, map.get(rightChar)+1);
                right++;
            } else {
                map.put(leftChar, map.get(leftChar)-1);
                if (map.get(leftChar) == 0) map.remove(leftChar);
                left++;
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        p386 sol = new p386();
        System.out.println(sol.lengthOfLongestSubstringKDistinct("eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh", 16));
    }
}
