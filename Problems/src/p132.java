import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Valued Customer on 12/14/2016.
 * Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix.
 * Example
 Given matrix:
 doaf
 agai
 dcan
 and dictionary:
 {"dog", "dad", "dgdg", "can", "again"}

 return {"dog", "dad", "can", "again"}


 A word can start from any position in the matrix and go left/right/up/down to the adjacent position.

 */
public class p132 {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        TrieNode root = new TrieNode();
        for (String word : words) {
            addWordToTrie(root, word);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> result = new HashSet<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                dfs(board, visited, root, "", result, row, col);
            }
        }
        return new ArrayList<>(result);
    }

    public void addWordToTrie(TrieNode root, String word) {
        TrieNode curr = root;
        for (char c: word.toCharArray()) {
            if (curr.children[c-'a'] == null) curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.hasWord = true;
    }

    public void dfs(char[][] board, boolean[][] visited, TrieNode node, String curr, Set<String> result, int row, int col) {
        if (node.hasWord && !result.contains(curr)) result.add(curr);
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0) return;
        if (visited[row][col]) return;
        char c = board[row][col];
        if (node.children[c-'a'] == null) return;
        visited[row][col] = true;
        dfs(board, visited, node.children[c-'a'], curr+c, result, row+1, col);
        dfs(board, visited, node.children[c-'a'], curr+c, result, row-1, col);
        dfs(board, visited, node.children[c-'a'], curr+c, result, row, col+1);
        dfs(board, visited, node.children[c-'a'], curr+c, result, row, col-1);
        visited[row][col] = false;
    }
}
