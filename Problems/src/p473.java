import java.util.List;

/**
 * Created by Valued Customer on 12/8/2016.
 * 设计一个包含下面两个操作的数据结构：addWord(word), search(word)

 addWord(word)会在数据结构中添加一个单词。而search(word)则支持普通的单词查询或是只包含.和a-z的简易正则表达式的查询。

 一个 . 可以代表一个任何的字母。

 注意事项

 你可以假设所有的单词都只包含小写字母 a-z。

 样例
 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad")  // return false
 search("bad")  // return true
 search(".ad")  // return true
 search("b..")  // return true
 */
public class p473 {
    // Adds a word into the data structure.
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
    public TrieNode root;

    public void addWord(String word) {
        // Write your code here
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c-'a'] == null) {
                current.children[c-'a'] = new TrieNode(c);
            }
            current = current.children[c-'a'];
        }
        current.hasWord = true;
    }
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        return searchHelper(word, 0, root);
    }
    public boolean searchHelper(String word, int i, TrieNode node) {
        if (word.length() == i) return node.hasWord;
        if (word.charAt(i) == '.') {
            for (TrieNode trieNode : node.children) {
                if (trieNode == null) continue;
                if (searchHelper(word, i+1, trieNode)) return true;
            }
            return false;
        } else {
            TrieNode nextNode = node.children[word.charAt(i)-'a'];
            if (nextNode == null || nextNode.value != word.charAt(i)) return false;
            return searchHelper(word, i+1, nextNode);
        }
    }

    // Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
    public p473() {
        root = new TrieNode();
    }
}
