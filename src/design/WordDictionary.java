package design;

import algorithm.Tree.Dao.TrieNode;

/**
 * Created by muni on 2020/8/5
 */
class WordDictionary {

    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int start) {
        if (node == null) return false;
        if (start == word.length()) return node.isWord;
        char c = word.charAt(start);
        if (c != '.') {
            return dfs(node.children[c - 'a'], word, start + 1);
        }
        for (int i=0; i<26; i++) {
            if (dfs(node.children[i], word, start+1)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println(wd.search("pad"));
        System.out.println(wd.search("bad"));
        System.out.println(wd.search(".ad"));
        System.out.println(wd.search("b.."));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */