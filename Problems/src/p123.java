/**
 * Created by Valued Customer on 12/14/2016.
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 or vertically neighboring. The same letter cell may not be used more than once.

 Example
 Given board =

 [
 "ABCE",
 "SFCS",
 "ADEE"
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
public class p123 {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (visited[row][col]) continue;
                if (dfs(board, visited, word, "", row, col)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] visited, String word, String curr, int row, int col) {
        if (word.equals(curr)) return true;
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0) return false;
        if (visited[row][col] || board[row][col] != word.charAt(curr.length())) return false;
        visited[row][col] = true;
        if (dfs(board, visited, word, curr + board[row][col], row+1, col)) return true;
        if (dfs(board, visited, word, curr + board[row][col], row-1, col)) return true;
        if (dfs(board, visited, word, curr + board[row][col], row, col+1)) return true;
        if (dfs(board, visited, word, curr + board[row][col], row, col-1)) return true;
        visited[row][col] = false;
        return false;
    }
}
