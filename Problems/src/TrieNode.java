/**
 * Created by Valued Customer on 12/14/2016.
 */
public class TrieNode {
    public char value;
    public boolean hasWord;
    public TrieNode[] children;
    public TrieNode() {
        children = new TrieNode[26];
    }
    public TrieNode(char c) {
        this();
        value = c;
    }
}
