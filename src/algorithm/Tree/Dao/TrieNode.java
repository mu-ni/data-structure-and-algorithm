package algorithm.Tree.Dao;

public class TrieNode {
    public boolean isWord = false;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {}
}
