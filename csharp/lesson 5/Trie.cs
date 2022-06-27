// https://leetcode.com/problems/implement-trie-prefix-tree/

# nullable enable
public class Trie
{
    private TrieNode root = new TrieNode();
    
    public void Insert(String word) 
    {
        var node = root;
        foreach (var c in word) 
        {
            if (node[c] == null)
            {
                node[c] = new TrieNode();
            }
            node = node[c];
        }
        node.IsWord = true;
    }
    
    public bool Search(String word)
    {
        var node = root;
        foreach (var c in word)
        {
            if (node[c] == null) return false;
            node = node[c];
        }
        return node.IsWord;
    }
    
    public bool StartsWith(String prefix) {
        var node = root;
        foreach (var c in prefix) 
        {
            if (node[c] == null) return false;
            node = node[c];
        }
        return true;
    }
    
    private class TrieNode {
        private TrieNode[] children = new TrieNode[26]; // a to z
        public bool IsWord { get; set; }
        
        public TrieNode? this[char c]
        {
            get => children[c - 'a'];
            set => children[c - 'a'] = value;
        }
    }
}
