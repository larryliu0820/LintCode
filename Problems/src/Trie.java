/**
 * Created by Valued Customer on 3/21/2017.
 *
 * Implement Trie
 *
 * Implement a trie with insert, search, and startsWith methods.

 Notice

 You may assume that all inputs are consist of lowercase letters a-z.

 Example
 insert("lintcode")
 search("code")
 >>> false
 startsWith("lint")
 >>> true
 startsWith("linterror")
 >>> false
 insert("linterror")
 search("lintcode)
 >>> true
 startsWith("linterror")
 >>> true

 */

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] wordChars = word.toCharArray();
        TrieNode node = root;
        for (char c : wordChars) {
            if (node.children[c-'a'] == null) {
                node.children[c-'a'] = new TrieNode(c);
            }
            node = node.children[c-'a'];
        }
        node.hasWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        char[] wordChars = word.toCharArray();
        TrieNode node = root;
        for (char c : wordChars) {
            if (node.children[c-'a'] == null) return false;
            if (node.children[c-'a'].value != c) return false;
            node = node.children[c-'a'];
        }
        return node.hasWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        char[] wordChars = prefix.toCharArray();
        TrieNode node = root;
        for (char c : wordChars) {
            if (node.children[c-'a'] == null) return false;
            if (node.children[c-'a'].value != c) return false;
            node = node.children[c-'a'];
        }
        return true;
    }
}
