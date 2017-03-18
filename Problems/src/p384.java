/**
 * Created by Valued Customer on 3/9/2017.
 *
 *  Longest Substring Without Repeating Characters
 *
 *  Given a string, find the length of the longest substring without repeating characters.

 Have you met this question in a real interview? Yes
 Example
 For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

 For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class p384 {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here

        if (s == null ) return 0;
        if ( s.length() <= 1) return s.length();
        int left = 0, right = 1;
        int len = 1;
        while (right < s.length()) {
            String sub = s.substring(left,right);
            String rightStr = s.substring(right, right+1);
            if (sub.contains(rightStr)) {
                left += sub.indexOf(rightStr) + 1;
            } else len = Math.max(len, right - left + 1);
            right++;
        }
        len = Math.max(len, right - left);
        return len;
    }

    public static void main(String[] args) {
        p384 sol = new p384();
        System.out.println(sol.lengthOfLongestSubstring("gehmbfqmozbpripibusbezagafqtypz"));
    }
}
