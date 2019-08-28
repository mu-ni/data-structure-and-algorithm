package algorithm.ArrayAndString;

import algorithm.TreeAndGraph.Dao.Trie;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        List<String> dict = Arrays.asList("aaaa","aaa");
        System.out.println(new WordBreak().wordBreak("aaaaaaa", dict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict) {
            trie.insert(word);
        }

        int start = 0;
        int end = 0;
        while (end < s.length()) {
            String sub = s.substring(start, end+1);
            String sub2 = s.substring(end+1);
            if (trie.search(sub)) {
                if (trie.search(sub2)) {
                    return true;
                }
                start = end+1;
                continue;
            }

            end++;
        }
        return start == s.length();
    }
}
