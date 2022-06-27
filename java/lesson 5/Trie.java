// https://leetcode.com/problems/implement-trie-prefix-tree/

public class Trie {
    private TrieNode root = new TrieNode();
    
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.get(c) == null) {
                node.set(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = findNode(prefix);
        return node != null;
    }
    
    private TrieNode findNode(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            node = node.get(c);
            if (node == null) return null;
        }
        return node;
    }
    
    private class TrieNode {
        private TrieNode[] children = new TrieNode[26]; // a to z
        public boolean isWord;
        
        public TrieNode get(Character c) {
            return children[c - 'a'];
        }
        
        public void set(Character c, TrieNode value) {
            children[c - 'a'] = value;
        }
    }
}
