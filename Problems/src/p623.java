import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valued Customer on 5/31/2017.
 *
 * K Edit Distance
 *
 * Given a set of strings which just has lower case letters and a target string, output all the strings for each the edit distance with the target no greater than k.

 You have the following 3 operations permitted on a word:

 Insert a character
 Delete a character
 Replace a character

 Example
 Given words = ["abc", "abd", "abcd", "adc"] and target = "ac", k = 1
 Return ["abc", "adc"]


 */
public class p623 {
    /**
     * @param words a set of stirngs
     * @param target a target string
     * @param k an integer
     * @return output all the strings that meet the requirements
     */
    int k;
    String s;
    List<String> result;

    public List<String> kDistance(String[] words, String target, int k) {
        // Write your code here
        this.result = new ArrayList<>();
        if (words == null || words.length == 0) return result;
        Trie trie = new Trie();
        for (String word : words) trie.insert(word);
        this.k = k;
        this.s = target;
        int[] dist = new int[s.length() + 1];
        for (int i = 0; i < dist.length; i++) dist[i] = i;
        search(trie.root, dist, "");
        return result;
    }

    private void search(TrieNode root, int[] prevDist, String path) {
        if (root.hasWord) {
            if (prevDist[prevDist.length - 1] <= k) result.add(path);
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] == null) continue;
            int[] currDist = new int[s.length() + 1];
            currDist[0] = path.length() + 1;
            char c = (char) ('a' + i);
            for (int j = 1; j <= s.length(); ++j) {
                if (s.charAt(j - 1) == c)
                    currDist[j] = prevDist[j - 1];
                else
                    currDist[j] = Math.min(Math.min(currDist[j - 1], prevDist[j]), prevDist[j - 1]) + 1;
            }

            search(root.children[i], currDist, path + c);
        }
    }

    public static void main(String[] args) {
        p623 sol = new p623();
        String[] words = new String[]{"as","ab","cf","da","ee","e","adee","eeda"};
        System.out.println(sol.kDistance(words, "eefab", 3));
    }
}
