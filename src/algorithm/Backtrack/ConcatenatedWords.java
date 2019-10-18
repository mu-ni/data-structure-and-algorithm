package algorithm.Backtrack;

import algorithm.Tree.Dao.Trie;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords {
    public static void main(String[] args) {
        String[] words = new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println(new ConcatenatedWords().findAllConcatenatedWordsInADict(words));
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if (words.length == 0) return new ArrayList<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<String> rst = new ArrayList<>();
        for (String word : words) {
            if (dfs(trie, word, 0, 0)) {
                rst.add(word);
            }
        }
        return rst;
    }

    public boolean dfs(Trie trie, String word, int start, int count) {
        if (start == word.length()) return count >= 2;

        for (int i=start; i<word.length(); i++) {
            String sub = word.substring(start, i+1);
            if (trie.search(sub)) {
                boolean found = dfs(trie, word, i+1, count+1);
                if (found) return true;
            }
        }
        return false;
    }
}
