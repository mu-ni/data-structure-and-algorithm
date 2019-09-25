package algorithm.DfsBfs;

import java.util.*;

public class WordLadder2 {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log", "cog");
        System.out.println(new WordLadder2().findLadders("hit", "cog", wordList));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // TODO
        List<List<String>> rst = new ArrayList<>();
        return rst;
    }
}
